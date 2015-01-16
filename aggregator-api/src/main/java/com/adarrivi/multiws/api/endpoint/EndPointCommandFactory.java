package com.adarrivi.multiws.api.endpoint;

import com.adarrivi.multiws.api.search.SearchRq;

public interface EndPointCommandFactory {

	GenericApiCommand createCommand(SearchRq request);

}
