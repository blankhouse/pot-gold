package com.blankhouse.project.potgold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blankhouse.project.potgold.mapper")
public class GoldWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldWebApplication.class, args);
	}
}
