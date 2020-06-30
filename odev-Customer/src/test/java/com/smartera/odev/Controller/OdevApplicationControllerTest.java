package com.smartera.odev.Controller;



import static org.mockito.Mockito.verify;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.smartera.odev.Entities.Customer;
import com.smartera.odev.Service.CustomerService;


@RunWith(SpringRunner.class)
@WebMvcTest
public class OdevApplicationControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CustomerService customerService;
	
	//private List<Customer> list;
	
	
	@Test
	public void getAllCustomersTest() throws Exception {
		
		//when(customerService.getAll()).thenReturn(Collections.emptyList());
		
		
		MvcResult mvcResult=	mockMvc.perform(
								MockMvcRequestBuilders.get("/api/customer/get")
								.accept(MediaType.APPLICATION_JSON)
							).andReturn();
		
		System.out.println(mvcResult.getResponse().getContentType());
		
		verify(customerService).getAll();
	}

	@Test
	public void getByIdTest() throws Exception {
		int id=1;
		
		MvcResult mvcResult=	mockMvc.perform(
				MockMvcRequestBuilders.get("/api/customer/get/{id}",id)
				.accept(MediaType.APPLICATION_JSON)
			).andReturn();
		System.out.println(mvcResult.getResponse());
		
		verify(customerService).getById(id);
	}
	
	@Test
	public void createTest() throws Exception {
		
		Customer testCustomer=new Customer(999,"test","test",true);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/api/customer/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(testCustomer)));
		//System.out.println(mvcResult.getResponse());
		
		//verify(customerService).create(testCustomer);
	}
	
	@Test
	public void updateTest() throws JsonProcessingException, Exception {
		Customer testCustomer=new Customer(999,"test","test",true);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/api/customer/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(testCustomer)));
		
	}
	
	@Test
	public void deleteTest() throws JsonProcessingException, Exception {
		Customer testCustomer=new Customer(999,"test","test",true);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/api/customer/delete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(testCustomer)));
		
	}
}
