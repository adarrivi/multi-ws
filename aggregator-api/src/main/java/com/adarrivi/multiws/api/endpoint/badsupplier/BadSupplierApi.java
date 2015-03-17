package com.adarrivi.multiws.api.endpoint.badsupplier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adarrivi.multiws.api.endpoint.RandomComponent;

@Component
class BadSupplierApi {

	private static final String OK_RESPONSE = "OK";

	private static final List<BadSupplierRs> DEFAULT_RESPONSES = new ArrayList<>();

	@Autowired
	private RandomComponent randomComponent;

	@PostConstruct
	public void setUpDefatulResponses() {
		List<BadSupplierProduct> products = new ArrayList<>();
		products.add(new BadSupplierProduct("AX34523X", "Nike shoes 8"));
		products.add(new BadSupplierProduct("B3345DDF", "Adidas t-shirt red"));
		products.add(new BadSupplierProduct("C3354D55", "Puma cup S"));

		DEFAULT_RESPONSES.add(new BadSupplierRs(OK_RESPONSE, randomComponent.getRandomSubSet(2, products)));
	}

	@SuppressWarnings("unused")
	BadSupplierRs search(BadSupplierRq request) {
		return randomComponent.anyItem(DEFAULT_RESPONSES);
	}

}
