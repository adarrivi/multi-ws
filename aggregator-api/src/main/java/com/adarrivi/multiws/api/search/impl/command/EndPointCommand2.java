package com.adarrivi.multiws.api.search.impl.command;

import org.springframework.stereotype.Component;

import com.adarrivi.multiws.api.search.AggregatedRs;
import com.adarrivi.multiws.api.search.impl.EndPointCommand;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

@Component
class EndPointCommand2 extends HystrixCommand<AggregatedRs> implements EndPointCommand<AggregatedRs> {

	EndPointCommand2() {
		super(HystrixCommandGroupKey.Factory.asKey("EndPointGroup2"));
	}

	@Override
	protected AggregatedRs run() throws Exception {
		// Do the IO operation
		return null;
	}

}
