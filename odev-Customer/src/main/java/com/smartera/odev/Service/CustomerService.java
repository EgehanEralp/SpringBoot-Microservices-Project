package com.smartera.odev.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartera.odev.Dao.ICustomerDao;

import com.smartera.odev.Entities.Customer;

@Service
public class CustomerService implements ICustomerService{

	ICustomerDao customerDao;

	
	@Autowired
	public CustomerService(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public CustomerService() {}

	@Override
	@Transactional
	public void create(Customer customer) {
		customerDao.create(customer);
	}

	@Override
	@Transactional
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	@Transactional
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	@Transactional
	public Customer getById(int cid) {
		return customerDao.getById(cid);
	}

	@Override
	@Transactional
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

}
