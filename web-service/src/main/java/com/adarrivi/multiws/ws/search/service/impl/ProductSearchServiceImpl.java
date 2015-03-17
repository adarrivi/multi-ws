package com.adarrivi.multiws.ws.search.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adarrivi.multiws.api.search.AggregatedRs;
import com.adarrivi.multiws.api.search.AggregatorSearchService;
import com.adarrivi.multiws.api.search.SearchRq;
import com.adarrivi.multiws.api.search.SearchRs;
import com.adarrivi.multiws.ws.search.ProductDto;
import com.adarrivi.multiws.ws.search.ProductSearchRq;
import com.adarrivi.multiws.ws.search.ProductSearchRs;
import com.adarrivi.multiws.ws.search.service.ProductSearchService;

@Service
class ProductSearchServiceImpl implements ProductSearchService {

	@Autowired
	private AggregatorSearchService aggregatorSearchService;

	@Override
	public ProductSearchRs searchProduct(ProductSearchRq request) {
		SearchRs searchRs = aggregatorSearchService.getAggregatedSearch(new SearchRq());
		List<ProductDto> products = searchRs.getResponses().stream().flatMap(this::toProductsDto)
				.collect(Collectors.toList());
		return new ProductSearchRs(products);
	}

	private Stream<ProductDto> toProductsDto(AggregatedRs productRs) {
		String merchant = productRs.getMerchant();
		return productRs.getProducts().stream()
				.map(product -> new ProductDto(product.getProductDescription(), merchant));
	}

}
