package com.adarrivi.multiws.api.endpoint.goodsupplier;

class GoodSupplierProduct {

	private String reference;
	private String description;

	GoodSupplierProduct(String reference, String description) {
		this.reference = reference;
		this.description = description;
	}

	String getReference() {
		return reference;
	}

	String getDescription() {
		return description;
	}

}
