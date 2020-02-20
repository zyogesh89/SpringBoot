package com.yogesh.storeservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogesh.storeservice.dao.store.ProductDao;
import com.yogesh.storeservice.model.store.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductDao productDao;

	@GetMapping(path = "/all")
	public List<Product> getAllProduct(HttpServletRequest request) {
		logger.info("All products");
		List<Product> products = this.productDao.findAll();
		return products;
	}
}
