package com.adarrivi.multiws.ws.integration;

public class JsonVerifier<T> {

	private T jsonObject;

	public JsonVerifier(T jsonObject) {
		this.jsonObject = jsonObject;
	}

	@SuppressWarnings({ "unchecked" })
	public void verifyJsonConversion() {
		JsonDto<T> jsonRq = new JsonDto<T>(jsonObject);
		String jsonString = jsonRq.toJsonString();
		jsonRq = new JsonDto<T>(jsonString, (Class<T>) jsonObject.getClass());
		jsonRq.toJsonObject();
	}

}
