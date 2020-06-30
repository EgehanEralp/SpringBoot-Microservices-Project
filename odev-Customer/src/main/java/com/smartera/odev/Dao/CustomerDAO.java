package com.smartera.odev.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smartera.odev.Entities.Customer;

@Repository
public class CustomerDAO implements ICustomerDao{

	
	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	@Override
	@Transactional
	public void create(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.save(customer);
	}

	
	@Override
	@Transactional
	public void update(Customer customer) {
		Session session= entityManager.unwrap(Session.class);
		session.update(customer);
	}

	
	@Override
	@Transactional
	public void delete(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		Customer silinecekCustomer = session.get(Customer.class, customer.getCid());
		session.delete(silinecekCustomer);
	}

	
	@Override
	@Transactional
	public Customer getById(int cid) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Customer.class, cid);
	}
	

	@Override
	@Transactional
	public List<Customer> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Customer> list= session.createQuery("from Customer",Customer.class).getResultList();
		return list;
	}

}
