package com.cochil.persistance;

import com.cochil.config.CochilProperties;
import com.cochil.domain.ingredient.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Repository
public class IngredientRepository {

    private Logger logger = LoggerFactory.getLogger(IngredientRepository.class);

    @Autowired
    private MongoTemplate mongoTemplate;
    private CochilProperties properties;

    @Autowired
    public IngredientRepository(CochilProperties properties) {
        this.properties = properties;
    }

    public void saveIngredient(Ingredient ingredient) {
        logger.debug("성분 저장.");

        switch (properties.getEnv()) {
            case "test":
                if (mongoTemplate.collectionExists(Ingredient.class)) {
                    mongoTemplate.dropCollection(Ingredient.class);
                }
                mongoTemplate.insert(ingredient);
                break;
            case "dev":
                mongoTemplate.insert(ingredient);
                break;
            default:
                throw new IllegalStateException("please sev env...");
        }
    }
}
