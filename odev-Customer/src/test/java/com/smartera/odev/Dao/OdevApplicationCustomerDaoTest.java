package com.smartera.odev.Dao;





import java.util.List;

import org.assertj.core.api.Assertions;

import org.junit.After;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;


import com.smartera.odev.Entities.Customer;




@Sql(
		scripts = {
				"classpath:customerSQL_testData.sql"
		}
)
@SpringBootTest
@RunWith(SpringRunner.class)
public class OdevApplicationCustomerDaoTest {

	
	@Autowired 
	private CustomerDAO customerDAO;
	  
	
	
	@After
	public void dbConf() {
		customerDAO.delete(new Customer(111,null,null,true));
		customerDAO.delete(new Customer(112,null,null,true));
		customerDAO.delete(new Customer(113,null,null,true));
		customerDAO.delete(new Customer(114,null,null,true));
	}
	
	
	@Test 
	public void testGetById() {  
		int id=111;
		  
		Customer customer = customerDAO.getById(id);
		  
		Assertions.assertThat(customer).isNotNull().hasFieldOrPropertyWithValue("cid",id); 
		
	}
	
	
	@Test 
	public void testGetAll() {
	
		List<Customer> list = customerDAO.getAll();
		
		Assertions.assertThat(list).isNotNull()
								.isNotEmpty();
		
	}
	 
	

	@Test
	public void testDeleteCustomer() {
		
		
		customerDAO.create(new Customer(999,"lol","lol",true));
		
		customerDAO.delete(new Customer(999,"lol","lol",true));
		
		Assertions.assertThat(customerDAO.getById(999)).isNull();
		
		
	}

	
	@Test
	public void testCreateCustomer() {
		
		Customer testCustomer = new Customer(999,"test","test",true);
		
		customerDAO.create(testCustomer);
		
		Assertions.assertThat(customerDAO.getById(999)).isNotNull();
		
		Assert.assertEquals(customerDAO.getById(999).getName(), "test");
		
		customerDAO.delete(new Customer(999,"test","test",true));
		
	}
	
	@Test
	public void testUpdateCustomer() {
		
		Customer oldCustomer = customerDAO.getById(111);
		
		customerDAO.update(new Customer(111,"newTestInp","newTestPsw",true));
		
		Assertions.assertThat(customerDAO.getById(111)).isNotNull().isNotEqualTo(oldCustomer);
		
		Assert.assertEquals(customerDAO.getById(111).getName(), "newTestInp");
	
	}
	
	
}
