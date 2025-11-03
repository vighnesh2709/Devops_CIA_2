package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class WebAppApplication {

	public static void main(String[] args) {
		System.out.print("Hello world");
        SpringApplication.run(WebAppApplication.class, args);
	}

    @RequestMapping("/test")
    public String testing(){
        return ("Hello world!");
    }

}
