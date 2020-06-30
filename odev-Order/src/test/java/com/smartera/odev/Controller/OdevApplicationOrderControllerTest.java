package com.smartera.odev.Controller;

//import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartera.odev.OdevApplicationOrder;
import com.smartera.odev.Entities.Order;
import com.smartera.odev.Service.OrderService;

@RunWith(SpringRunner.class)
@WebMvcTest(OdevApplicationOrder.class)
@ContextConfiguration(classes=OdevApplicationOrder.class)
public class OdevApplicationOrderControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	OrderService orderService;
	
	@Test
	public void getAllCustomersTest() throws Exception {
		
		//when(customerService.getAll()).thenReturn(Collections.emptyList());
		
		this.mockMvc.perform(
								MockMvcRequestBuilders.get("/api/order/get")
								.accept(MediaType.APPLICATION_JSON)
							).andReturn();
		
		//System.out.println(mvcResult.getResponse().getContentType());
		
		//verify(orderService).getAll();
	}
	
	@Test
	public void getByIdTest() throws Exception {
		int id=1;
		
		this.mockMvc.perform(
				MockMvcRequestBuilders.get("/api/order/get/{id}",id)
				.accept(MediaType.APPLICATION_JSON)
			).andReturn();
		//System.out.println(mvcResult.getResponse());
		
		//verify(orderService).getById(id);
	}
	
	@Test
	public void createTest() throws Exception {
		
		Order testOrder=new Order(999,1,"[\"urunler\"]");
		
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/api/order/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(testOrder)));
		//System.out.println(mvcResult.getResponse());
		
		//verify(customerService).create(testCustomer);
	}
	
	@Test
	public void updateTest() throws JsonProcessingException, Exception {
		Order testOrder=new Order(999,1,"[\"urunler\"]");
		
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/api/order/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(testOrder)));
		
	}
	
	@Test
	public void getByCidTest() throws Exception {
		int cid =1;
		this.mockMvc.perform(
				MockMvcRequestBuilders.get("/api/order/searchByCid/{cid}",cid)
				.accept(MediaType.APPLICATION_JSON)
			).andReturn();
	}
	
}
