package com.uciext.springfw.hw.catalog.services.impl;

import com.uciext.springfw.hw.catalog.dao.CatalogDao;
import com.uciext.springfw.hw.catalog.dao.OrderDao;
import com.uciext.springfw.hw.catalog.dao.ProductDao;
import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Order;
import com.uciext.springfw.hw.catalog.model.Product;
import com.uciext.springfw.hw.catalog.services.CatalogService;
import com.uciext.springfw.hw.catalog.services.CatalogServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by clawrence on 7/15/17.
 */
public class CatalogServiceImpl implements CatalogService{

    private static Logger logger = Logger.getLogger(CatalogServiceImpl.class);

    // DAO classes
    private CatalogDao catalogDao;
    public void setCatalogDao(CatalogDao catalogDao) {
        this.catalogDao = catalogDao;
    }

    private ProductDao productDao;
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    private OrderDao orderDao;
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    @Autowired
    public CatalogServiceImpl(CatalogDao catalogDao, ProductDao productDao, OrderDao orderDao) {
    	logger.info("In CatalogServiceImpl()");
    	this.catalogDao = catalogDao;
    	this.productDao = productDao;
    	this.orderDao = orderDao;
    	
    }
    
    public CatalogServiceImpl() {
        logger.info("In CatalogServiceImpl()");
    }


    @Override
    @Transactional
    public Catalog getCatalog(int catalogId) {
        return catalogDao.findCatalogByCatalogId(catalogId);

    }

    @Override
    @Transactional
    public List<Catalog> getCatalogs(){

        return (List<Catalog>) catalogDao.findAll();
    }

    @Override
    @Transactional
    public Product getProduct(int productId) {
        return productDao.findProductByProductId(productId);

    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        return (List<Product>) productDao.findAll();

    }

    @Override
    @Transactional
    public List<Product> getProductsByCatalog(Catalog catalog) {
        return (List<Product>) productDao.findProductByCatalog(catalog);
    }

    @Override
    @Transactional
    public void addProduct(Product product) throws CatalogServiceException {

        if (product == null) {
            throw new CatalogServiceException("Product is undefined");
        }
        else {

            productDao.save(product);

        }

    }

    @Override
    @Transactional
    public void updateProduct(Product product) throws CatalogServiceException {

        if (product == null) {
            throw new CatalogServiceException("Product is undefined");
        }
        else {

            productDao.save(product);

        }

    }

    @Override
    @Transactional
    public void deleteProduct(Product product) throws CatalogServiceException {

        if (product == null) {
            throw new CatalogServiceException("Product is undefined");
        }
        else {

logger.info("Deleting " + product.toString());
            productDao.delete(product);

        }

    }

    @Override
    public List<Product> getProductsInStockByCatalog(Catalog catalog) {
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public Order getOrderById(int orderid) {
        return null;
    }

    @Override
    public List<Order> getOrdersByUser(String user) {
        return orderDao.findOrdersByUser(user);
    }

    @Override
    public void addOrder(Order order) {

    }

    @Override
    public void completeOrder(Order order) {

    }
}
