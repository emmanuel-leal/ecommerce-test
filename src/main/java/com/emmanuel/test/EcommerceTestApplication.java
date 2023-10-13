package com.emmanuel.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Slf4j
public class EcommerceTestApplication {

	public static void main(String[] args) {
			SpringApplication.run(EcommerceTestApplication.class, args);
	}

}
