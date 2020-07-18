package com.salaoarrazus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalaoArrazusApplication {

	private static Logger logger = LoggerFactory.getLogger(SalaoArrazusApplication.class);
	public static void main(String[] args) {
		logger.info("### - Iniciando aplicacao");
		SpringApplication.run(SalaoArrazusApplication.class, args);
	}

}
