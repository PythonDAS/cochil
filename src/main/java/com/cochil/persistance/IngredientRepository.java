package com.cochil.persistance;

import com.cochil.domain.ingredient.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
}
