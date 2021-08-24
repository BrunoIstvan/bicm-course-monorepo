package br.com.bicmsystems.bicmworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BICMWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BICMWorkerApplication.class, args);
	}

}
