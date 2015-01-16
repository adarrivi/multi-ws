package com.adarrivi.multiws.api.endpoint.goodsupplier;

import java.util.List;

class GoodSupplierRs {

	private String status;
	private List<GoodSupplierProduct> products;

	public GoodSupplierRs(String status, List<GoodSupplierProduct> products) {
		this.status = status;
		this.products = products;
	}

	public String getStatus() {
		return status;
	}

	public List<GoodSupplierProduct> getProducts() {
		return products;
	}

}
