package com.cochil.service;

import com.cochil.domain.ingredient.Ingredient;
import com.cochil.persistance.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Service
public class IngredientService implements IIngredientService {

    @Autowired
    private IngredientRepository repository;

    @Override
    public void saveIngredient(Ingredient ingredient) {
        if (ingredient == null)
            throw new NullPointerException("ingredient is null...");

        repository.saveIngredient(ingredient);
    }
}
