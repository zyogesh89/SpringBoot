package com.yogesh.storeservice.dao.store;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yogesh.storeservice.model.store.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public List<Customer> findAll();

	public Customer findByCustomerName(String customerName);

	public Customer findByCustomerId(Integer customerName);

	@SuppressWarnings("unchecked")
	public Customer saveAndFlush(Customer customer);

}
