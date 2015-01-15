package com.adarrivi.multiws.api.search.impl;

import com.netflix.hystrix.HystrixExecutable;

public interface EndPointCommand<R> extends HystrixExecutable<R> {

}
