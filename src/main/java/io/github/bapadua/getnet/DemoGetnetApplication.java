package io.github.bapadua.getnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DemoGetnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGetnetApplication.class, args);
	}

}
