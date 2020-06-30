package com.smartera.odev.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartera.odev.Dao.ICustomerDao;
import com.smartera.odev.Dao.IOrderDao;
import com.smartera.odev.Entities.Order;

@Service
public class OrderService implements IOrderService{

	
	IOrderDao orderDao;
	ICustomerDao customerDao;
	
	@Autowired
	public OrderService(IOrderDao orderDao, ICustomerDao customerDao) {
		this.orderDao = orderDao;
		this.customerDao = customerDao;
	}

	public OrderService() {}
	
	@Override
	@Transactional
	public void create(Order order) throws Exception {
		
		if(customerDao.getById(order.getCid())!=null) {
			
			if((customerDao.getById(order.getCid())).isOrderpermission()) {
				orderDao.create(order);
			}
			else {
				throw new Exception("There is no permission.");
			}
		}
		else {
			throw new Exception("Unmatching customer id.");
		}
	}

	@Override
	@Transactional
	public void update(Order order) throws Exception {
		if(customerDao.getById(order.getCid())!=null) {
			
			if((customerDao.getById(order.getCid())).isOrderpermission()) {
				orderDao.update(order);
			}
			else {
				throw new Exception("There is no permission.");
			}
		}
		else {
			throw new Exception("Unmatching customer id.");
		}
		
	}

	@Override
	@Transactional
	public List<Order> getAll() {
		return orderDao.getAll();
	}

	@Override
	@Transactional
	public Order getById(int oid) {
		return orderDao.getById(oid);
	}

	@Override
	public List<Order> getByCustomerId(int cid){	
		return orderDao.getByCustomerId(cid);
	}

}
