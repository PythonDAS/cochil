package com.cochil.service.ingredient;

import com.cochil.domain.ingredient.Ingredient;
import com.cochil.persistance.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Service
@Transactional
public class IngredientService implements IIngredientService {

    @Autowired
    private IngredientRepository repository;

    /**
     * mongodb save 함수는 upsert 로 동작한다.
     *
     * @param ingredient
     */
    @Override
    public Ingredient save(Ingredient ingredient) {
        if (ingredient == null)
            throw new NullPointerException("ingredient is null...");

        return repository.save(ingredient);
    }

    @Override
    public Page<Ingredient> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


}
