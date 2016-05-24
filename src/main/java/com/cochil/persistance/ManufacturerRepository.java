package com.cochil.persistance;

import com.cochil.domain.ingredient.Ingredient;
import com.cochil.domain.manufacturer.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Repository
public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {
}
