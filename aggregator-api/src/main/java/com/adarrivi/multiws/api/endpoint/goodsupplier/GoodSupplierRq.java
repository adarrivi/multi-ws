package com.adarrivi.multiws.api.endpoint.goodsupplier;

class GoodSupplierRq {

	private String brandName;
	private String operation;
	private String client;

	GoodSupplierRq(String brandName, String operation, String client) {
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
