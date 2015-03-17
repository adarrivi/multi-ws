package com.adarrivi.multiws.api.endpoint.badsupplier;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarrivi.multiws.api.endpoint.EndPointCommandFactory;
import com.adarrivi.multiws.api.endpoint.GenericApiCommand;
import com.adarrivi.multiws.api.search.AggregatedRs;
import com.adarrivi.multiws.api.search.ProductInfo;
import com.adarrivi.multiws.api.search.SearchRq;

@Service
class BadSupplierCommandFactoryImpl implements EndPointCommandFactory {

	private static final String HYSTRIX_COMMAND_GROUP = "BadSupplierApi";
	private static final String MERCANT_ID = "BadSupplierInc";
	@Autowired
	private BadSupplierApi badSupplierApi;

	@Override
	public GenericApiCommand createCommand(SearchRq request) {
		return new GenericApiCommand(HYSTRIX_COMMAND_GROUP, request, this::requestSearch);
	}

	private AggregatedRs requestSearch(SearchRq request) {
		BadSupplierRs supplierRs = badSupplierApi.search(toBadSupplierRq(request));
		return toAggregatedRs(supplierRs);
	}

	private BadSupplierRq toBadSupplierRq(SearchRq request) {
		return new BadSupplierRq("brandName", "search", "multi-ws");
	}

	private AggregatedRs toAggregatedRs(BadSupplierRs response) {
		List<ProductInfo> products = response.getProducts().stream()
				.map(product -> new ProductInfo(product.getReference(), product.getDescription()))
				.collect(Collectors.toList());
		return new AggregatedRs(MERCANT_ID, products);
	}

}
