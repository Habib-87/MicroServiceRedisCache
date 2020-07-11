package com.habib.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import jdk.jfr.Enabled;

@SpringBootApplication
@EnableCaching
public class MicroServiceRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceRedisCacheApplication.class, args);
	}

}
