package com.skr.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;

@SpringBootApplication
public class SkrV1Application {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(SkrV1Application.class, args);
	}

}
