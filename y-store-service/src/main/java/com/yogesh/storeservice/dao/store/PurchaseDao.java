package com.yogesh.storeservice.dao.store;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yogesh.storeservice.model.store.Purchase;

public interface PurchaseDao extends JpaRepository<Purchase, Integer> {

}
