package com.adarrivi.multiws.ws.search;

public class ProductDto {

	private String productName;
	private String merchant;

	ProductDto() {
	}

	public ProductDto(String productName, String merchant) {
		this.productName = productName;
		this.merchant = merchant;
	}

	public String getProductName() {
		return productName;
	}

	public String getMerchant() {
		return merchant;
	}

}
