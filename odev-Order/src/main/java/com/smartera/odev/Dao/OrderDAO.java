package com.smartera.odev.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smartera.odev.Entities.Order;

@Repository
public class OrderDAO implements IOrderDao{

	private EntityManager entityManager;
	
	@Autowired
	public OrderDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public OrderDAO() {}

	
	@Override
	@Transactional
	public void create(Order order) {
		Session session = entityManager.unwrap(Session.class);
		session.save(order);
	}

	@Override
	@Transactional
	public void update(Order order) {
		Session session = entityManager.unwrap(Session.class);
		session.update(order);
	}

	@Override
	@Transactional
	public List<Order> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Order> list = session.createQuery("from Order", Order.class).getResultList();
		return list;
	}

	@Override
	@Transactional
	public Order getById(int oid) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Order.class,oid);
	}
	@Transactional
	@Override
	public List<Order> getByCustomerId(int cid) {
		Session session = entityManager.unwrap(Session.class);
		List<Order> list = session.createQuery("from Order where cid="+cid, Order.class).getResultList();
		return list;
	}
	@Transactional
	public void deleteByOid(int oid) { //test için oluşturuldu.
		Session session = entityManager.unwrap(Session.class);
		session.delete(session.get(Order.class, oid));
	}
	
}
