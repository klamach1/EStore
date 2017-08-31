package com.uciext.springfw.hw;

import com.uciext.springfw.hw.catalog.model.Catalog;

import com.uciext.springfw.hw.catalog.model.Product;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.uciext.springfw.hw.catalog.services.CatalogService;

import java.math.BigDecimal;

public class EStoreApp {

	private static Logger logger = Logger.getLogger(EStoreApp.class.getName());

	public static void main(String[] args) {

        logger.info("Start");

		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/EStoreConfig.xml");
		CatalogService catalogService = context.getBean("catalogService",CatalogService.class);

		// Make a call
		logger.info("Coming Soon");
	}
}
