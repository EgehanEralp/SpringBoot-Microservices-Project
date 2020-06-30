package com.smartera.odev.Dao;

import java.util.List;

import com.smartera.odev.Entities.Customer;

public interface ICustomerDao {
	
	public void create(Customer customer);
	
	public void update(Customer customer);
	
	public void delete(Customer customer);
	
	public Customer getById(int cid);
	
	public List<Customer> getAll();

}
