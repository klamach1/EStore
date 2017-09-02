package com.uciext.springfw.hw.catalog.dao.springdatajpa;

import com.uciext.springfw.hw.catalog.dao.ProductDao;
import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface SpringDataJpaProductDao extends ProductDao, Repository<Product, Integer> {
    public void save(Product product);
    public void delete(Product product);
    public Product findProductByProductId(int productId);
    public List<Product> findAll();
    public List<Product> findProductByCatalog(Catalog catalog);
    public List<Product> findProductsByCatalogAndAvailableQuantityGreaterThan(Catalog catalog, int availableQuantity);
}
