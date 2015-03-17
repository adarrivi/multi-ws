package com.adarrivi.multiws.api.endpoint.badsupplier;

class BadSupplierProduct {

	private String reference;
	private String description;

	BadSupplierProduct(String reference, String description) {
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
