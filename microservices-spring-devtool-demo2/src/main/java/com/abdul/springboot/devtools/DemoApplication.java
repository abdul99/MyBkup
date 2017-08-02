package com.abdul.springboot.devtools;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	 @PostConstruct
	    void demo() {
	        System.out.println("****hello! everyone****");
	    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
