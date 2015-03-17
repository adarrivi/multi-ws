package com.adarrivi.multiws.api.endpoint.badsupplier;

class BadSupplierRq {

	private String brandName;
	private String operation;
	private String client;

	BadSupplierRq(String brandName, String operation, String client) {
		this.brandName = brandName;
		this.operation = operation;
		this.client = client;
	}

	String getBrandName() {
		return brandName;
	}

	String getOperation() {
		return operation;
	}

	String getClient() {
		return client;
	}

}
