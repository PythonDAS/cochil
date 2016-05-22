package com.cochil;

import com.cochil.config.CochilProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class CochilInputDataApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(CochilInputDataApplication.class);

    @Autowired
    private CochilProperties props;

    public static void main(String[] args) {
        SpringApplication.run(CochilInputDataApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Map<String, Map<String, String>> servers = props.getServers();
        Map<String, String> mongoInfo = servers.get("mongo");
        String host = mongoInfo.get("host");
        int port = Integer.parseInt(mongoInfo.get("port"));
        String database = mongoInfo.get("database");

        logger.info("Host: {}", host);
        logger.info("Port: {}", port);
        logger.info("Database: {}", database);
    }
}