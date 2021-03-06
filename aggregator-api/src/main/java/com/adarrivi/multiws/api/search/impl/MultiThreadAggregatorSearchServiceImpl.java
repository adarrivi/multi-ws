package com.adarrivi.multiws.api.search.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rx.Observable;

import com.adarrivi.multiws.api.endpoint.EndPointCommandFactory;
import com.adarrivi.multiws.api.endpoint.GenericApiCommand;
import com.adarrivi.multiws.api.search.AggregatedRs;
import com.adarrivi.multiws.api.search.AggregatorSearchService;
import com.adarrivi.multiws.api.search.SearchRq;
import com.adarrivi.multiws.api.search.SearchRs;

@Service
class MultiThreadAggregatorSearchServiceImpl implements AggregatorSearchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MultiThreadAggregatorSearchServiceImpl.class);

	@Autowired
	private List<EndPointCommandFactory> endPointCommandFactories;

	@Override
	public SearchRs getAggregatedSearch(SearchRq request) {

		Stream<GenericApiCommand> commandStream = endPointCommandFactories.stream().map(
				factory -> factory.createCommand(request));
		List<Observable<AggregatedRs>> observables = commandStream.map(command -> command.toObservable()).collect(
				Collectors.toList());
		Observable<AggregatedRs> unifiedObservable = mergeObservables(observables);
		SearchRs response = new SearchRs();
		unifiedObservable.toBlocking().forEach(aggregatedResopnse -> addResponse(response, aggregatedResopnse));
		return response;
	}

	// Unfortunately The RX API doesn't provide a way to merge more than 10
	// observables
	private Observable<AggregatedRs> mergeObservables(List<Observable<AggregatedRs>> observables) {
		if (observables.size() == 1) {
			return observables.get(0);
		}
		Observable<AggregatedRs> unifiedObservable = Observable.mergeDelayError(observables.get(0), observables.get(1));
		for (int i = 2; i < observables.size(); i++) {
			unifiedObservable = Observable.mergeDelayError(unifiedObservable, observables.get(i));
		}
		return unifiedObservable;
	}

	private void addResponse(SearchRs mainResponse, AggregatedRs aggregatedResponse) {
		LOGGER.debug("Response received: {}", aggregatedResponse);
		mainResponse.add(aggregatedResponse);
	}

}
