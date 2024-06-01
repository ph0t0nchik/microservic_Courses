package ru.courses.microservicmaximov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
public class MicroservicMaximovApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicMaximovApplication.class, args);
	}

}
