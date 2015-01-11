package com.adarrivi.multiws.ws.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adarrivi.multiws.ws.search.ProductSearchRq;
import com.adarrivi.multiws.ws.search.ProductSearchRs;
import com.adarrivi.multiws.ws.search.service.ProductSearchService;

@RestController
public class ProductSearchController {

    @Autowired
    private ProductSearchService productSearchService;

    @RequestMapping(value = "/search/product/get", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductSearchRs getCategoryConfig(@RequestBody ProductSearchRq request) {
        return productSearchService.searchProduct(request);
    }

}
