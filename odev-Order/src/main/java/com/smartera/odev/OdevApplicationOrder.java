package com.smartera.odev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OdevApplicationOrder {

	public static void main(String[] args) {
		SpringApplication.run(OdevApplicationOrder.class, args);
	}

}
