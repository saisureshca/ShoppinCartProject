package com.project.ShoppingCart;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import com.mongodb.client.MongoClient;

public class MongoDBConfiguration {
	
	private static final String MONGO_DB_URL = "localhost";

	private static final String MONGO_DB_NAME = "embeded_db";

	@Bean
	public MongoTemplate mongoTemplate() throws IOException {
		EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
		mongo.setBindIp(MONGO_DB_URL);
		MongoClient mongoClient = (MongoClient) mongo.getObject();
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
		return mongoTemplate;

	}

}
