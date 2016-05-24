package com.cochil.service;

import com.cochil.domain.ingredient.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by donghoon on 2016. 5. 22..
 */
public interface IIngredientService {
    void save(Ingredient ingredient);

    Page<Ingredient> findAll(Pageable pageable);
}
