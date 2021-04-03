package com.hidarisoft.animeMX;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AnimeMxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeMxApplication.class, args);
	}

}
