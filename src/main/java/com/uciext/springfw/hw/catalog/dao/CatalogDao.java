package com.uciext.springfw.hw.catalog.dao;

import com.uciext.springfw.hw.catalog.model.Catalog;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface CatalogDao {

    public void save(Catalog catalog);
    public Catalog findCatalogByCatalogId(int catalogId);
    public List<Catalog> findAll();

}
