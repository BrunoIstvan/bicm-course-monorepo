package br.com.bicmsystems.bicmeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BICMEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BICMEurekaServerApplication.class, args);
	}

}
