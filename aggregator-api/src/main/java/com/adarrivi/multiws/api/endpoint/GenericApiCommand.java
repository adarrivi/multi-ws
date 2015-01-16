package com.adarrivi.multiws.api.endpoint;

import java.util.function.Function;

import com.adarrivi.multiws.api.search.AggregatedRs;
import com.adarrivi.multiws.api.search.SearchRq;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GenericApiCommand extends HystrixCommand<AggregatedRs> {

	private SearchRq request;
	private Function<SearchRq, AggregatedRs> apiFunction;

	public GenericApiCommand(String groupName, SearchRq request, Function<SearchRq, AggregatedRs> apiFunction) {
		super(HystrixCommandGroupKey.Factory.asKey(groupName));
		this.request = request;
		this.apiFunction = apiFunction;
	}

	@Override
	public AggregatedRs run() throws Exception {
		return apiFunction.apply(request);
	}

}
