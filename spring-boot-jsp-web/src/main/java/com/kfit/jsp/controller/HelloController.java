package com.kfit.jsp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 测试
 */
@Controller
public class HelloController {
// 从application.properties 中读取配置，如取不到默认值为Hello Shanhy
	@Value("${application.hello:Hello Angel}")
	private String hello;

	@RequestMapping("/helloJsp") //RequestMapping报错就是版本号的问题所致
	public String helloJsp(Map<String, Object> map) {
		System.out.println("HelloController.helloJsp().hello=" + hello);
		map.put("hello", hello);
		return "helloJsp";
	}
}