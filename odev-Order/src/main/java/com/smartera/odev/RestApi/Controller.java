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


import com.smartera.odev.Entities.Order;

import com.smartera.odev.Service.IOrderService;


@RestController
@RequestMapping("/api")
public class Controller {


	IOrderService orderService;
	
	@Autowired
	public Controller( IOrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@PostMapping("/order/create")
	public void func(@RequestBody Order order) throws Exception {
		orderService.create(order);
	}
	
	@PostMapping("/order/update")
	public void upd(@RequestBody Order order) throws Exception {
		orderService.update(order);
	}
	
	@GetMapping("/order/get")
	public List<Order> fnc() {
		return orderService.getAll();
	}
	
	@GetMapping("/order/get/{oid}")
	public Order fnc2(@PathVariable int oid) {
		return orderService.getById(oid);
	}
	
	@GetMapping("/order/searchByCid/{cid}")
	public List<Order> fnc3(@PathVariable int cid){
		return orderService.getByCustomerId(cid);
	}
	
	
	@GetMapping("/documentation")
	public String doc() {
		String doc = "";
		try { 
			doc = new String(Files.readAllBytes(Paths.get("/Users/egehaneralp/eclipse-workspace/odev-Order/src/main/resources/static/documentation.txt"))); 
		} catch (IOException e) {
			e.printStackTrace(); 
		} 

		return doc;
	}
	
}
