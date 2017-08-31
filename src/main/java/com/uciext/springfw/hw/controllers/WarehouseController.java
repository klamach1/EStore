package com.uciext.springfw.hw.controllers;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.CatalogList;
import com.uciext.springfw.hw.catalog.model.Product;
import com.uciext.springfw.hw.catalog.model.ProductList;
import com.uciext.springfw.hw.catalog.services.CatalogService;
import com.uciext.springfw.hw.catalog.services.CatalogServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class WarehouseController {

    private CatalogService catalogService;

    @Autowired
    public WarehouseController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping(value="/catalogs", method= RequestMethod.GET)
    public @ResponseBody  CatalogList cataloglist() {
        ArrayList<Catalog> catList = (ArrayList<Catalog>) catalogService.getCatalogs();

        CatalogList catalogList = new CatalogList();

        for (Catalog catalog : catList) {
            catalogList.getCatalogs().add(catalog);
        }

        return catalogList;
    }

    @RequestMapping(value="/catalogs/{catalogId}/products", method = RequestMethod.GET)
    public @ResponseBody ProductList productList(@PathVariable("catalogId") int catalogId) {

        Catalog catalog = catalogService.getCatalog(catalogId);

        ArrayList<Product> productArrayList = (ArrayList<Product>) catalogService.getProductsByCatalog(catalog);

        ProductList productList = new ProductList();

        for (Product product : productArrayList) {

            productList.getProducts().add(product);

        }

        return productList;


    }

    @RequestMapping(value="/catalogs/{catalogId}/products/{productId}", method = RequestMethod.GET)
    public @ResponseBody Product product(@PathVariable("catalogId") int catalogId,
                                         @PathVariable("productId") int productId) {

        Product product = catalogService.getProduct(productId);

        return product;
    }

    @RequestMapping(value="/catalogs/{catalogId}/products/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable("catalogId") int catalogId,
                              @PathVariable("productId") int productId,
                              @Valid @RequestBody Product product) {

        try {
            product.setCatalog(catalogService.getCatalog(catalogId));
            product.setProductId(productId);
            catalogService.updateProduct(product);
        } catch (CatalogServiceException cse) {

        }

    }


}
