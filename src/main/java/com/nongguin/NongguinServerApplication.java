package com.nongguin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@MapperScan("com.nongguin.model.dao")
public class NongguinServerApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(NongguinServerApplication.class, args);
	}

}
