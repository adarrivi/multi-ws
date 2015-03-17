package com.adarrivi.multiws.api.search;

import java.util.Collection;

public class AggregatedRs {

	private String merchant;
	private Collection<ProductInfo> products;

	public AggregatedRs(String merchant, Collection<ProductInfo> products) {
		this.merchant = merchant;
		this.products = products;
	}

	public String getMerchant() {
		return merchant;
	}

	public Collection<ProductInfo> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "AggregatedRs [merchant=" + merchant + ", products=" + products + "]";
	}

}
