package org.mangobutter.jelly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceJellyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceJellyApplication.class, args);
	}
}
