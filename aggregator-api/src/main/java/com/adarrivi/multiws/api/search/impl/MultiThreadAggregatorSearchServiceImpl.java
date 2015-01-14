package com.adarrivi.multiws.api.search.impl;

import org.springframework.stereotype.Service;

import com.adarrivi.multiws.api.search.AggregatorSearchService;
import com.adarrivi.multiws.api.search.SearchRq;
import com.adarrivi.multiws.api.search.SearchRs;

@Service
class MultiThreadAggregatorSearchServiceImpl implements AggregatorSearchService{

	@Override
	public SearchRs getAggregatedSearch(SearchRq request) {
		return null;
	}

}
