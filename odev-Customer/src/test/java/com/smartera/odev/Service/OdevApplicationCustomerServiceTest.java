package com.smartera.odev.Service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.mockito.Mockito;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.smartera.odev.Dao.CustomerDAO;
import com.smartera.odev.Entities.Customer;



@RunWith(SpringRunner.class)
@SpringBootTest
public class OdevApplicationCustomerServiceTest {

	//for service test
	@Autowired
	private CustomerService customerService; //test cases for Service Layer methods
	
	//for dao test
	@MockBean
	private CustomerDAO customerDao; //sahte nesne (mock nesnesi) oluşturdum. Methodlar DB ile bağımsız kontrol edilir.
	
	
	
	@Test
	public void getAllTest() {
		
		//dao katmanında getAll methodu çağrılırsa => yazmış olduğum 2 adet satırı döndürmesini bekliyorum. 
		// bu method başarılı bir şekilde çağrılailiyor mu?
		
		when(customerDao.getAll()).thenReturn(Stream.of(new Customer(8,"baba","amandaman",true), new Customer(9,"lol","lolke",false)).collect(Collectors.toList()));
		
		assertEquals(2, customerService.getAll().size());//service katmanında ilgili dao methodu doğru çağırılıyor mu?
	}
	
	
	@Test
	public void getByIdTest() {
		
		int testId=1;
		Customer customer = new Customer(1,"asdasd","lol",true);
		
		when(customerDao.getById(testId)).thenReturn(customer); //customerDao dan sahte olarak bu veri döndürülecekmiş
		
		assertNotNull(customerService.getById(testId)); //??? service katmanından dao daki bu methoda erişildiğinde döndürülen sahte veriyi alabiliyo muyuz?
		
		assertEquals(testId, customerService.getById(testId).getCid()); //??? döndürülen sahte veri benim testte tanımladığım veri ile aynı mı?
	}
	
	
	@Test 
	public void createCustomerTest() {
		Customer customer = new Customer(999,"asdasd","lol",true);
		customerService.create(customer); //service deki create çağrıldığında 
		
		verify(customerDao,Mockito.times(1)).create(customer);//deo daki delete methodu da çağrıldı mı?
	  
	  }
	 
	
	@Test
	public void deleteTest() {
		Customer customer = new Customer(1,"asdasd","lol",true); //silinecek Custoemr
		
		//verify ile bir methodun çağırılıp çağrılmadığına bakarız.
		
		//service sınıfında delete methodu çağrılıyor. ve ardından Dao daki delete çağrılacak mı kontrolü yapılıyor.
		
		customerService.delete(customer);
		verify(customerDao,Mockito.times(1)).delete(customer); //dao daki delete method da çağrıldı mı?
	}
	
	@Test
	public void updateTest() {
		Customer customer = new Customer(123,"deneme","denemepsw",false);
		
		customerService.update(customer);	
		verify(customerDao,Mockito.times(1)).update(customer);
		
	}
	
}
