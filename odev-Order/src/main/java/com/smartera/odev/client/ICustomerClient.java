package com.smartera.odev.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartera.odev.Entities.Customer;

@FeignClient(value="odev-Customer", url="https://localhost:5000/api")
public interface ICustomerClient {

	@RequestMapping(method=RequestMethod.GET, value="/customer/get")
	List<Customer> getCustomers();

	@RequestMapping(method = RequestMethod.GET, value="/customer/get/{id}", produces="application/json")
    Customer getCustomerById(@PathVariable("cid") int cid);
}
