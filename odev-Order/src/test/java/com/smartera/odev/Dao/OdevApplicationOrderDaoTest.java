package com.smartera.odev.Dao;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.hamcrest.collection.HasItemInArray;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.smartera.odev.OdevApplicationOrder;

import com.smartera.odev.Entities.Order;





@Sql(
		scripts = {
				"classpath:orderSQL_testData.sql"
		}
)
@SpringBootTest(classes = OdevApplicationOrder.class)
@RunWith(SpringRunner.class)
public class OdevApplicationOrderDaoTest {
	
	@Autowired 
	private OrderDAO orderDAO;
	  
	
	
	@After
	public void DBconf() {
		orderDAO.deleteByOid(111);
		orderDAO.deleteByOid(112);
		orderDAO.deleteByOid(113);
		orderDAO.deleteByOid(114);
	}
	
	
	@Test
	public void testGetAll() {
		List<Order> list = orderDAO.getAll();
		
		Assertions.assertThat(list).isNotNull()
								.isNotEmpty();
	}
	
	
	@Test
	public void testGetByOid() {
		int oid =1;
		
		Order order = orderDAO.getById(oid);
		
		Assertions.assertThat(order).isNotNull();
		
	}
	
	@Test
	public void testCreate() {
				
		Order order = new Order(999,1,"[\"urunler\"]");
		
		orderDAO.create(order);
		
		Assertions.assertThat(orderDAO.getById(999)).isNotNull();
		Assert.assertEquals(orderDAO.getById(999).getCid(), order.getCid());
		Assert.assertEquals(orderDAO.getById(999).getProducts(), order.getProducts());
		
		orderDAO.deleteByOid(999);
	}
	
	@Test
	public void testUpdate() {
		
		Order oldOrder = orderDAO.getById(111);
		
		Order updatedOrder = new Order(111,1,"[\"Monitor\"]");
		
		orderDAO.update(updatedOrder);
		
		Assert.assertNotEquals(orderDAO.getById(111), oldOrder);
			
	}
	
	@Test
	public void testSearchByCid() {
		
		Order order=orderDAO.getById(111);
		
		List<Order> list = orderDAO.getByCustomerId(3);
		
		Assertions.assertThat(list.contains(order)).isNotNull();
		
	}
	
	
	
}
