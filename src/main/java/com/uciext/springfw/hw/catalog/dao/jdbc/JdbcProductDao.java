package com.uciext.springfw.hw.catalog.dao.jdbc;

import com.uciext.springfw.hw.catalog.dao.ProductDao;
import com.uciext.springfw.hw.catalog.model.Catalog;
import com.uciext.springfw.hw.catalog.model.Product;
import com.uciext.springfw.hw.catalog.services.CatalogService;
import com.uciext.springfw.hw.common.Util;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


public class JdbcProductDao  {

    protected static Logger logger = Logger.getLogger(JdbcProductDao.class.getName());

    // SQL statements
    private static final String SQL_INSERT_PRODUCT =
            "INSERT INTO product (product_id, catalog_id, product_name, sku, available_quantity," +
                    "uom)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_PRODUCT =
            "UPDATE product " +
                    "set catalog_id = ?, product_name = ?, sku = ?, available_quantity = ?,uom = ? " +
                    "WHERE product_id = ?";
    private static final String SQL_DELETE_PRODUCT =
            "DELETE FROM product WHERE product_id = ?";
    private static final String SQL_FIND_PRODUCT_BY_ID =
            "SELECT * FROM product WHERE product_id = ?";
    private static final String SQL_FIND_PRODUCTS =
            "SELECT * FROM product";
    private static final String SQL_FIND_PRODUCTS_BY_CATALOG =
            "SELECT * FROM product WHERE catalog_id = ?";

    // Datasource
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Course service
    private CatalogService catalogService;

    public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }



    //=================================================
    // DB methods

    
    public void insertProduct(Product product) {
        logger.info("In insertProduct product=" + product);
        Connection conn = null;

        try {
            product.setProductId(Util.getRandomInt());

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT_PRODUCT);
            ps.setInt(1, product.getProductId());
            ps.setInt(2, product.getCatalog().getCatalogId());
            ps.setString(3, product.getProductName());
            ps.setString(4, product.getSku());
            ps.setInt(5, product.getAvailableQuantity());
            ps.setString(6, product.getUnitOfMeasure());
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    
    public void updateProduct(Product product) {
        logger.info("In updateProduct product=" + product);
        Connection conn = null;

        try {
            product.setProductId(Util.getRandomInt());

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_PRODUCT);
            ps.setInt(1, product.getCatalog().getCatalogId());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getSku());
            ps.setInt(4, product.getAvailableQuantity());
            ps.setString(5, product.getUnitOfMeasure());
            ps.setInt(6, product.getProductId());
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    
    public void deleteProduct(Product product) {
        logger.info("In deleteProduct productId=" + product.getProductId());
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_DELETE_PRODUCT);
            ps.setInt(1, product.getProductId());
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
        logger.info("exit delete product=" + product);
    }


    
    public Product findProductById(int productId) {
        logger.info("In findProductById productId=" + productId);
        Connection conn = null;
        Product product = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCT_BY_ID);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product(
                        rs.getInt("product_id"),
                        catalogService.getCatalog(rs.getInt("catalog_id")),
                        rs.getString("sku"),
                        rs.getString("product_name"),
                        rs.getString("uom"),
                        rs.getInt("available_quantity")
                );
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
        logger.info("exit findByProductId product=" + product);
        return product;
    }

    
    public List<Product> findProducts() {
        logger.info("In findProducts");
        Connection conn = null;
        List<Product> products = new ArrayList<Product>();

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCTS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        catalogService.getCatalog(rs.getInt("catalog_id")),
                        rs.getString("sku"),
                        rs.getString("product_name"),
                        rs.getString("uom"),
                        rs.getInt("available_quantity")
                );
                products.add(product);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
        logger.info("exit findProducts");
        return products;
    }

    
    public List<Product> findProductsByCatalog(Catalog catalog) {
        logger.info("In findProductsByCourse catalog=" + catalog);
        Connection conn = null;
        List<Product> products = new ArrayList<Product>();

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_PRODUCTS_BY_CATALOG);
            ps.setInt(1, catalog.getCatalogId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("product_id"),
                        catalogService.getCatalog(rs.getInt("catalog_id")),
                        rs.getString("sku"),
                        rs.getString("product_name"),
                        rs.getString("uom"),
                        rs.getInt("available_quantity")

                );
                products.add(product);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
        logger.info("exit findProductsByCourse");
        return products;
    }


}
