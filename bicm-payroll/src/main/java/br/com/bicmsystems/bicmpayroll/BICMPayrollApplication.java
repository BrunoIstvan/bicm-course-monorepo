package br.com.bicmsystems.bicmpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BICMPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(BICMPayrollApplication.class, args);
	}

}
