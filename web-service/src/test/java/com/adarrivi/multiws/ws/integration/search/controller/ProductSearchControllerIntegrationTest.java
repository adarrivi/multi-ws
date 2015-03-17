package com.adarrivi.multiws.ws.integration.search.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adarrivi.multiws.ws.integration.GenericWebIntegrationTest;
import com.adarrivi.multiws.ws.integration.JsonDto;
import com.adarrivi.multiws.ws.search.ProductSearchRq;

public class ProductSearchControllerIntegrationTest extends GenericWebIntegrationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductSearchControllerIntegrationTest.class);

	@Test
	public void serach() {
		LOGGER.debug("running search");
		whenGetProducts();
		getIntegrationTestHttpRequest().logResponse();
	}

	private void whenGetProducts() {
		JsonDto<ProductSearchRq> request = new JsonDto<>(new ProductSearchRq("a"));
		getIntegrationTestHttpRequest().performJsonPost("/search/product/get", request);
	}

}
