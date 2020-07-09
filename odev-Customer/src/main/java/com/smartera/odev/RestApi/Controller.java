package com.smartera.odev.RestApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartera.odev.Entities.Customer;
//import com.smartera.odev.Entities.Order;
import com.smartera.odev.Service.ICustomerService;
//import com.smartera.odev.Service.IOrderService;
//import com.sun.xml.bind.v2.schemagen.xmlschema.Documentation;

//import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/api")
public class Controller {

	ICustomerService customerService;
	//IOrderService orderService;
	
	@Autowired
	public Controller(ICustomerService customerService) {
		this.customerService = customerService;
		//this.orderService = orderService;
	}
	
	@PostMapping("/customer/create")
	public void cr(@RequestBody Customer customer) {
		customerService.create(customer);
		
		
	}
	
	@PostMapping("/customer/update")
	public void up(@RequestBody Customer customer) {
		customerService.update(customer);
	}
	
	@PostMapping("/customer/delete")
	public void del(@RequestBody Customer customer) {
		customerService.delete(customer);
	}
	
	@GetMapping("/customer/get")
	public List<Customer> get1(){
		return customerService.getAll();
	}
	
	@GetMapping("/customer/get/{id}")
	public Customer getid(@PathVariable int id) {
		return customerService.getById(id);
	}
	
	
	
}
