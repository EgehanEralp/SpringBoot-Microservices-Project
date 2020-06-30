package com.smartera.odev.Service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.smartera.odev.OdevApplicationOrder;
import com.smartera.odev.Dao.OrderDAO;
import com.smartera.odev.Entities.Order;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = OdevApplicationOrder.class)
public class OdevApplicationTestsOrderServiceTest {

	
	@Autowired
	private OrderService orderService; //service test edilecek
	
	@MockBean
	private OrderDAO orderDao; //sahte dao nesnesi. Methodları DB den bağımsız çalıştıracak.
	
	
	@Test
	public void getAllTest() {
		when(orderDao.getAll()).thenReturn(Stream.of(new Order(1,1,"laptop")).collect(Collectors.toList()));
		assertEquals(1, orderService.getAll().size());	
	}
	
	@Test
	public void getByIdTest() {
		
		int orderidTest=1;
		Order order = new Order(1,2,"mouse"); //döndürülecek order
		
		when(orderDao.getById(orderidTest)).thenReturn(order);//orderDao daki getById çağırıldığında bu nesneyi döndür.
		
		assertEquals(orderidTest, orderService.getById(orderidTest).getOid()); //verilen ID ve dönen nesnenin ID si eşit mi?
		
	}
	
	@Test
	public void createOrderTest() throws Exception {
		Order order=new Order(1,1,"mouse");//eklenecek nesne
		
		orderService.create(order);
		verify(orderDao,Mockito.times(1)).create(order);
		
	}
	
	@Test
	public void updateTest() throws Exception {
		Order order=new Order(1,1,"mouse");//oid==1 olan nesne güncellenecek nesne
		
		orderService.update(order);
		verify(orderDao,Mockito.times(1)).update(order);
	}
	
	
	@Test 
	public void getByCustomerIdTest() { 
		int cid=1;
	  
		List<Order> list = new ArrayList<Order>(); 
		list.add(new Order(1,1,"psd"));
		list.add(new Order(2,1,"psd2")); 
		list.add(new Order(3,1,"psd3"));
		  
		when(orderDao.getByCustomerId(cid)).thenReturn(list);
		  
		assertEquals(orderService.getByCustomerId(cid), list);
  
	  
	  }
	 
	
}
