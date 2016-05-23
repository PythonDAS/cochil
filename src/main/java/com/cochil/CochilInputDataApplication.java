package com.cochil;

import com.cochil.config.CochilProperties;
import com.cochil.domain.ingredient.Ingredient;
import com.cochil.service.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;

@EnableWebMvc
@SpringBootApplication
public class CochilInputDataApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(CochilInputDataApplication.class);

    @Autowired
    private CochilProperties props;
    @Autowired
    private IngredientService service;

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

        logger.debug("Mongo Host: {}", host);
        logger.debug("Mongo Port: {}", port);
        logger.debug("Mongo Database: {}", database);


        /**
         * test data.
         */
        Ingredient ingredient = new Ingredient();
        ingredient.setName("테스트");
        ingredient.setExplanation("테스트");

        service.saveIngredient(ingredient);
    }

    /**
     * static folder 이하에 있는 정적자원들 인식.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }
}