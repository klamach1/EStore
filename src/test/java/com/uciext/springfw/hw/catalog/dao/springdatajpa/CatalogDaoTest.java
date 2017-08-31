package com.uciext.springfw.hw.catalog.dao.springdatajpa;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uciext.springfw.hw.catalog.model.Catalog;
@ContextConfiguration(locations = {"classpath:META-INF/spring/EStoreConfig.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CatalogDaoTest {

	Catalog catalog;

	@Autowired
	SpringDataJpaCatalogDao springDataJpaCatalogDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {

		String catalogName = "MyTestCatalog" + String.valueOf(Math.random());

		catalog = new Catalog(0,catalogName);
		
		ArrayList<Catalog> catalogs = (ArrayList<Catalog>) springDataJpaCatalogDao.findAll();
		
		int preCount = catalogs.size();

		springDataJpaCatalogDao.save(catalog);
		catalogs = (ArrayList<Catalog>) springDataJpaCatalogDao.findAll();
		
		int postCount = catalogs.size();

	    assertEquals(postCount, preCount+1);
		
	
	}

	@Test
	public void deleteTest() {

	}

}
