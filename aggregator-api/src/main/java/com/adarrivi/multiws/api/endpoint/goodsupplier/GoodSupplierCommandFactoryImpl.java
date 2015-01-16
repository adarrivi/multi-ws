package com.adarrivi.multiws.api.endpoint.goodsupplier;

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
class GoodSupplierCommandFactoryImpl implements EndPointCommandFactory {

	private static final String HYSTRIX_COMMAND_GROUP = "GoodSupplierApi";
	private static final String MERCANT_ID = "GoodSupplierInc";
	@Autowired
	private GoodSupplierApi goodSupplierApi;

	@Override
	public GenericApiCommand createCommand(SearchRq request) {
		return new GenericApiCommand(HYSTRIX_COMMAND_GROUP, request, this::requestSearch);
	}

	private AggregatedRs requestSearch(SearchRq request) {
		GoodSupplierRs goodSupplierRs = goodSupplierApi.search(toGoodSupplierRq(request));
		return toAggregatedRs(goodSupplierRs);
	}

	private GoodSupplierRq toGoodSupplierRq(SearchRq request) {
		return new GoodSupplierRq("brandName", "search", "multi-ws");
	}

	private AggregatedRs toAggregatedRs(GoodSupplierRs response) {
		List<ProductInfo> products = response.getProducts().stream()
				.map(product -> new ProductInfo(product.getReference(), product.getDescription()))
				.collect(Collectors.toList());
		return new AggregatedRs(MERCANT_ID, products);
	}

}
