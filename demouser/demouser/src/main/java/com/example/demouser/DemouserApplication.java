package com.example.demouser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemouserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemouserApplication.class, args);
	}

	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable String name, @RequestParam(value="lastname") String lastName){

		return "Hello"+ name+lastName;
	}
}
