package com.uciext.springfw.hw.catalog.dao.jdbc;

import com.uciext.springfw.hw.catalog.dao.CatalogDao;
import com.uciext.springfw.hw.catalog.model.Catalog;
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

public class JdbcCatalogDao implements CatalogDao {

protected static Logger logger = Logger.getLogger(JdbcCatalogDao.class.getName());

// SQL statements
private static final String SQL_INSERT_CATALOG =
        "INSERT INTO catalog (catalog_id, catalog_name) "
        + " VALUES (?, ?)";
private static final String SQL_FIND_CATALOG_BY_ID =
        "SELECT * FROM catalog WHERE catalog_id = ?";
private static final String SQL_FIND_CATALOGS =
        "SELECT * FROM catalog";

    // Datasource
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void save(Catalog catalog) {

        logger.info("In insertCatalog catalog=" + catalog);
        Connection conn = null;

        try {
            catalog.setCatalogId(Util.getRandomInt());

            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT_CATALOG);
            ps.setInt(1, catalog.getCatalogId());
            ps.setString(2, catalog.getCatalogName());
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


    @Override
    public Catalog findCatalogByCatalogId(int catalogId) {
        logger.info("In findCatalogById catalogId=" + catalogId);
        Connection conn = null;
        Catalog catalog = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_CATALOG_BY_ID);
            ps.setInt(1, catalogId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                catalog = new Catalog(
                        rs.getInt("catalog_id"),
                        rs.getString("catalog_name")
                );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        logger.info("exit findByCatalogId catalog=" + catalog);
        return catalog;
    }

    @Override
    public List<Catalog> findAll() {
        logger.info("In findCatalogs");
        Connection conn = null;
        List<Catalog> catalogs = new ArrayList<Catalog>();

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_CATALOGS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                catalogs.add(new Catalog(
                        rs.getInt("catalog_id"),
                        rs.getString("catalog_name")
                ));
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
        logger.info("exit findCatalogs catalogs.size=" + (catalogs != null ? catalogs.size() : 0));
        return catalogs;
    }
}
