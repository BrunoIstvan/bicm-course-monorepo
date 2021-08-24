package br.com.bicmsystems.bicmpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@RibbonClient(name = "bicm-worker")
@EnableFeignClients
@SpringBootApplication
public class BICMPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(BICMPayrollApplication.class, args);
	}

}
