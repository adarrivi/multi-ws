package com.adarrivi.multiws.ws.search;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchRs {

	private List<ProductDto> products = new ArrayList<>();

	ProductSearchRs() {
		// Needed by json parser
	}

	public ProductSearchRs(List<ProductDto> products) {
		this.products = products;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

}
