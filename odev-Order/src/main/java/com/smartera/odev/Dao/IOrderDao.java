package com.smartera.odev.Dao;

import java.util.List;

import com.smartera.odev.Entities.Order;

public interface IOrderDao {

	void create(Order order);
	
	void update(Order order);
	
	List<Order> getAll();
	
	Order getById(int oid);

	List<Order> getByCustomerId(int cid);
}
