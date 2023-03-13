package com.rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoforcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoforcacheApplication.class, args);
	}

}
