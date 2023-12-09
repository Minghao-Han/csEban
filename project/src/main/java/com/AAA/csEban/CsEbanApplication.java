package com.AAA.csEban;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan(basePackages = "com.AAA.csEban.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CsEbanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsEbanApplication.class, args);
	}

}
