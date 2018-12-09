package com.kfit.environment;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoProperties {
	private String host;
	//private int port = DBPort.PORT;
	private String uri = "mongodb://localhost/test";
	private String database;
// ... getters/ setters omitted
}