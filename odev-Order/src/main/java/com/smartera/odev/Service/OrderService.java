package com.smartera.odev.Service;

import java.util.List;

import com.smartera.odev.Entities.Customer;
import com.smartera.odev.client.ICustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.smartera.odev.Dao.IOrderDao;
import com.smartera.odev.Entities.Order;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService implements IOrderService{

	
	IOrderDao orderDao;

	//ICustomerClient customerClient;
	
	@Autowired
	public OrderService(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public OrderService() {}
	
	@Override
	@Transactional
	public void create(Order order) throws Exception {

		//List<Customer> customerList = customerClient.getCustomers();
		//Customer customer= customerClient.getCustomerById(order.getCid());

		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject("http://localhost:5000/api/customer/get/"+order.getCid(), Customer.class);

		if(customer != null){
			if(customer.isOrderpermission()){
				orderDao.create(order);
			}
			else{
				throw new Exception("There is no permission");
			}
		}
		else{
			throw new Exception("Unmatching customer id");
		}

		/*
		if(orderDao.getByCustomerId(order.getCid())!=null){

			if(customer.isOrderpermission()){
				orderDao.create(order);
			}else{
				throw new Exception("There is no permission.");
			}
		}else{
			throw new Exception("Unmatching customer id.");
		}


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
		*/

	}

	@Override
	@Transactional
	public void update(Order order) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject("http://localhost:5000/api/customer/get/"+order.getCid(), Customer.class);

		if(customer != null){
			if(customer.isOrderpermission()){
				orderDao.update(order);
			}
			else{
				throw new Exception("There is no permission");
			}
		}
		else{
			throw new Exception("Unmatching customer id");
		}

		/*
		Customer customer= customerClient.getCustomerById(order.getCid());

		if(orderDao.getByCustomerId(order.getCid())!=null){

			if(customer.isOrderpermission()){
				orderDao.update(order);
			}else{
				throw new Exception("There is no permission.");
			}
		}else{
			throw new Exception("Unmatching customer id.");
		}



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
		 */
		
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
