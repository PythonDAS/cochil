package com.cochil.persistance;

import com.cochil.config.CochilProperties;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Map;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Configuration
@EnableMongoRepositories
public class MongoConfig {
    @Autowired
    private CochilProperties cochilProperties;

    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(getMongoInfo("host"), Integer.parseInt(getMongoInfo("port")));
    }

    // ---------------------------------------------------- MongoTemplate
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongo(), getMongoInfo("database"));
        //set mongo db writeConcern option "safe" to receive server acknowledge.
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);
        return mongoTemplate;
    }

    private String getMongoInfo(String key) {
        Map<String, Map<String, String>> servers = cochilProperties.getServers();
        Map<String, String> mongoInfo = servers.get("mongo");
        return mongoInfo.get(key);
    }
}
