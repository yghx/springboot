package com.kfit.jsp;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class App extends SpringBootServletInitializer {
// @Override
// protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
// return application.sources(App.class);
// }
	public static void main(String[] args) {
		/**
		 * SpringApplication更加底层的原理
		 */
		SpringApplication springApplication = new SpringApplication(App.class);
		//springApplication.setBannerMode(Banner.Mode.CONSOLE);
		springApplication.setBanner(new MyBanner()); 
		springApplication.run(args);
		//SpringApplication.run(App.class, args);
	}
}

class MyBanner implements Banner{

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
		//banner.txt文件优先级比该方法优先级高
		System.err.println("明天要上班了额!");
	}
}