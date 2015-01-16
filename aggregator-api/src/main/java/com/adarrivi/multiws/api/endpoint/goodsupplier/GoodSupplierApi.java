package com.adarrivi.multiws.api.endpoint.goodsupplier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adarrivi.multiws.api.endpoint.RandomComponent;

@Component
class GoodSupplierApi {

	private static final String OK_RESPONSE = "OK";

	private static final List<GoodSupplierRs> DEFAULT_RESPONSES = new ArrayList<>();

	@Autowired
	private RandomComponent randomComponent;

	@PostConstruct
	public void setUpDefatulResponses() {
		List<GoodSupplierProduct> products = new ArrayList<>();
		products.add(new GoodSupplierProduct("AX34523X", "Nike shoes 8"));
		products.add(new GoodSupplierProduct("AX34524X", "Nike shoes 9"));
		products.add(new GoodSupplierProduct("AX34525B", "Nike shoes 9.5"));
		products.add(new GoodSupplierProduct("B3345DDF", "Adidas t-shirt red"));
		products.add(new GoodSupplierProduct("B7545DDF", "Adidas t-shirt blue"));
		products.add(new GoodSupplierProduct("B7256DDG", "Adidas t-shirt black"));
		products.add(new GoodSupplierProduct("C3354D55", "Puma cup S"));
		products.add(new GoodSupplierProduct("C3354D56", "Puma cup M"));
		products.add(new GoodSupplierProduct("C3354D57", "Puma cup L"));

		DEFAULT_RESPONSES.add(new GoodSupplierRs(OK_RESPONSE, randomComponent.getRandomSubSet(3, products)));
		DEFAULT_RESPONSES.add(new GoodSupplierRs(OK_RESPONSE, randomComponent.getRandomSubSet(2, products)));
		DEFAULT_RESPONSES.add(new GoodSupplierRs(OK_RESPONSE, randomComponent.getRandomSubSet(1, products)));
		DEFAULT_RESPONSES.add(new GoodSupplierRs(OK_RESPONSE, randomComponent.getRandomSubSet(5, products)));
	}

	@SuppressWarnings("unused")
	GoodSupplierRs search(GoodSupplierRq request) {
		return randomComponent.anyItem(DEFAULT_RESPONSES);
	}

}
