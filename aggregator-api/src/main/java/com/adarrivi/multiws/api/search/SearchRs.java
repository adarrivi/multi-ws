package com.adarrivi.multiws.api.search;

import java.util.ArrayList;
import java.util.Collection;

public class SearchRs {

	private Collection<AggregatedRs> responses = new ArrayList<>();

	public void add(AggregatedRs response) {
		responses.add(response);
	}

	public Collection<AggregatedRs> getResponses() {
		return responses;
	}

}
