package com.yogesh.storeservice.dao.store;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yogesh.storeservice.model.store.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	public List<Product> findAll();

	public Product findByProductId(Integer productId);

}
