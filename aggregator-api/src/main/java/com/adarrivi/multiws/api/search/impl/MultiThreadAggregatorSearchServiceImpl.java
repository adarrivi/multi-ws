package com.adarrivi.multiws.api.search.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import rx.Observable;
import rx.observables.BlockingObservable;

import com.adarrivi.multiws.api.search.AggregatedRs;
import com.adarrivi.multiws.api.search.AggregatorSearchService;
import com.adarrivi.multiws.api.search.SearchRq;
import com.adarrivi.multiws.api.search.SearchRs;

@Service
class MultiThreadAggregatorSearchServiceImpl implements AggregatorSearchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MultiThreadAggregatorSearchServiceImpl.class);

	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public SearchRs getAggregatedSearch(SearchRq request) {

		Collection<EndPointCommand<AggregatedRs>> commands = createCommands();

		List<Observable<AggregatedRs>> observables = commands.stream().map(command -> command.observe())
				.collect(Collectors.toList());
		observables.forEach(observable -> observable.subscribe(this::responseReceived, this::errorReceived));

		BlockingObservable<AggregatedRs> unifiedBlokingObservable = getUnifiedObservable(observables).toBlocking();
		SearchRs response = new SearchRs();
		unifiedBlokingObservable.forEach(response::add);
		return response;
	}

	private Observable<AggregatedRs> getUnifiedObservable(List<Observable<AggregatedRs>> observables) {
		if (observables.size() == 1) {
			return observables.get(0);
		}
		Observable<AggregatedRs> unifiedObservable = Observable.mergeDelayError(observables.get(0), observables.get(1));
		for (int i = 2; i < observables.size(); i++) {
			unifiedObservable = Observable.mergeDelayError(unifiedObservable, observables.get(i));
		}
		return unifiedObservable;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Collection<EndPointCommand<AggregatedRs>> createCommands() {
		return (Collection) applicationContext.getBeansOfType(EndPointCommand.class).values();
	}

	private void responseReceived(AggregatedRs response) {
		// Log something here?
	}

	private void errorReceived(Throwable error) {
		// ThrowException or log?
	}
}
