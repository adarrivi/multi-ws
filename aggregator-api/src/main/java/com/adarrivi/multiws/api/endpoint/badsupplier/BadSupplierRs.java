package com.adarrivi.multiws.api.endpoint.badsupplier;

import java.util.List;

class BadSupplierRs {

	private String status;
	private List<BadSupplierProduct> products;

	public BadSupplierRs(String status, List<BadSupplierProduct> products) {
		this.status = status;
		this.products = products;
	}

	public String getStatus() {
		return status;
	}

	public List<BadSupplierProduct> getProducts() {
		return products;
	}

}
