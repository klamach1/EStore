package com.uciext.springfw.hw.catalog.dao.springdatajpa;

import com.uciext.springfw.hw.catalog.dao.CatalogDao;
import com.uciext.springfw.hw.catalog.model.Catalog;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface SpringDataJpaCatalogDao extends CatalogDao, Repository<Catalog, Integer> {
	public void save(Catalog catalog);
	
    public Catalog findCatalogByCatalogId(int catalogId);
    public List<Catalog> findAll();
}
