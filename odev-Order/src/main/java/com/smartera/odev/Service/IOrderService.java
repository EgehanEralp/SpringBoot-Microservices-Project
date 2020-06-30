package com.smartera.odev.Service;

import java.util.List;

import com.smartera.odev.Entities.Order;

public interface IOrderService {

	void create(Order order) throws Exception;
	
	void update(Order order) throws Exception;
	
	List<Order> getAll();
	
	Order getById(int oid);
	
	List<Order> getByCustomerId(int cid);
	
}
