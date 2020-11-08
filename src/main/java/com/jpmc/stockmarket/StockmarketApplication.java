package com.jpmc.stockmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.jpmc"})
public class StockmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockmarketApplication.class, args);
	}

}
