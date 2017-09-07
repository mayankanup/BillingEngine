package mayank.anup.BillingEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan("mayank.anup.controller")
public class BillingEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingEngineApplication.class, args);
	}
}
