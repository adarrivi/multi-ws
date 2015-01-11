package com.adarrivi.multiws.ws.search.service;

import com.adarrivi.multiws.ws.search.ProductSearchRq;
import com.adarrivi.multiws.ws.search.ProductSearchRs;

public interface ProductSearchService {

    ProductSearchRs searchProduct(ProductSearchRq request);

}
