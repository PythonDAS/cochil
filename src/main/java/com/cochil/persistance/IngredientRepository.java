package com.cochil.persistance;

import com.cochil.domain.ingredient.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by donghoon on 2016. 5. 22..
 */
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
}
