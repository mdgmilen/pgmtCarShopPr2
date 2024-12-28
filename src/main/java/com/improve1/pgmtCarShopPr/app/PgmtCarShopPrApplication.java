package com.improve1.pgmtCarShopPr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.improve1.pgmtCarShopPr")
//@ComponentScan(basePackages = {"com.improve1.pgmtCarShopPr1.repositories"})
//@ComponentScan(basePackages = "com.improve1.pgmtCarShopPr1")
// , "com.improve1.pgmtCarShopPr1.controllers"
//@EnableJpaRepositories("com.improve1.pgmtCarShopPr1.repository")
public class PgmtCarShopPrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgmtCarShopPrApplication.class, args);
	}

}
