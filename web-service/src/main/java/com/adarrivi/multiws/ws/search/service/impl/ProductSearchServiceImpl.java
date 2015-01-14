package com.adarrivi.multiws.ws.search.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarrivi.multiws.api.search.AggregatorSearchService;
import com.adarrivi.multiws.ws.search.ProductSearchRq;
import com.adarrivi.multiws.ws.search.ProductSearchRs;
import com.adarrivi.multiws.ws.search.service.ProductSearchService;

@Service
class ProductSearchServiceImpl implements ProductSearchService {

	@Autowired
	private AggregatorSearchService aggregatorSearchService;

	@Override
	public ProductSearchRs searchProduct(ProductSearchRq request) {
		return null;
	}

}
