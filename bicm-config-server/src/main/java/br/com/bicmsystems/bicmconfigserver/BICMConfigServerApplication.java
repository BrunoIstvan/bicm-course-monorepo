package br.com.bicmsystems.bicmconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BICMConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BICMConfigServerApplication.class, args);
	}

}
