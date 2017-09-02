package com.uciext.springfw.hw.catalog.dao;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface ProductDao {

    public void save(Product product);
    public void delete(Product product);
    public Product findProductByProductId(int productId);
    public List<Product> findAll();
    public List<Product> findProductByCatalog(Catalog catalog);
    public List<Product> findProductsByCatalogAndAvailableQuantityGreaterThan(Catalog catalog, int availableQuantity);
}
