package com.uciext.springfw.hw.catalog.services;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import com.uciext.springfw.hw.catalog.dao.CatalogDao;
import com.uciext.springfw.hw.catalog.dao.OrderDao;
import com.uciext.springfw.hw.catalog.dao.ProductDao;
import com.uciext.springfw.hw.catalog.model.Product;
import com.uciext.springfw.hw.catalog.services.impl.CatalogServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uciext.springfw.hw.catalog.model.Catalog;
@ContextConfiguration(locations = {"classpath:META-INF/spring/EStoreConfig.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogServiceImplTest {


    @Autowired
    CatalogDao catalogDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    CatalogService catalogService;

    @Test
    public void getProductsWithAvailableQuantityTest() {

        Catalog catalog = catalogService.getCatalogs().get(0);
        List<Product> availProducts = catalogService.getProductsInStockByCatalog(catalog);

        Assert.assertFalse(availProducts.isEmpty());

    }
}
