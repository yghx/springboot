package com.kfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 这个就是扫描相应的Servlet包;
public class SpringBootSampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, new String[] {"hello","world"});
	}
}