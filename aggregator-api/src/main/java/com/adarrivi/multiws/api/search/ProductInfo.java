package com.adarrivi.multiws.api.search;

public class ProductInfo {

	private String productReference;
	private String productDescription;

	public ProductInfo(String productReference, String productDescription) {
		this.productReference = productReference;
		this.productDescription = productDescription;
	}

	public String getProductReference() {
		return productReference;
	}

	public String getProductDescription() {
		return productDescription;
	}

}
