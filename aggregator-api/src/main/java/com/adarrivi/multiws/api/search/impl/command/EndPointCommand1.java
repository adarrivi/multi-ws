package com.adarrivi.multiws.api.search.impl.command;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.adarrivi.multiws.api.search.AggregatedRs;
import com.adarrivi.multiws.api.search.impl.EndPointCommand;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

@Component
@Scope("prototype")
class EndPointCommand1 extends HystrixCommand<AggregatedRs> implements EndPointCommand<AggregatedRs> {

	EndPointCommand1() {
		super(HystrixCommandGroupKey.Factory.asKey("EndPointGroup1"));
	}

	@Override
	protected AggregatedRs run() throws Exception {
		// Do the IO operation
		return null;
	}

}
