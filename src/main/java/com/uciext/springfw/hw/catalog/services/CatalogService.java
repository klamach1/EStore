package com.uciext.springfw.hw.catalog.services;

import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Order;
import com.uciext.springfw.hw.catalog.model.Product;

import java.util.List;

/**
 * Created by clawrence on 7/15/17.
 */
public interface CatalogService {

    public List<Catalog> getCatalogs();

    public Catalog getCatalog(int catalogId);

    public List<Product> getProducts();

    public List<Product> getProductsInStockByCatalog(Catalog catalog);

    public List<Product> getProductsByCatalog(Catalog catalog);

    public Product getProduct(int productId);

    public void addProduct(Product product) throws CatalogServiceException;

    public void updateProduct(Product product) throws CatalogServiceException;

    public void deleteProduct(Product product) throws CatalogServiceException;

    public List<Order> getOrders();

    public Order getOrderById(int orderid);

    public List<Order> getOrdersByUser(String user);

    public Order saveOrder(Order order);





}
