package com.adarrivi.multiws.ws.search;

import org.junit.Test;

import com.adarrivi.multiws.ws.integration.JsonVerifier;

public class ProductSearchRqTest {

	@Test
	public void jsonParsing() {
		JsonVerifier<ProductSearchRq> verifier = new JsonVerifier<ProductSearchRq>(new ProductSearchRq("id"));
		verifier.verifyJsonConversion();
	}
}
