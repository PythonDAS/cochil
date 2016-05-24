package com.cochil.domain.ingredient;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Data
public class IngredientForm {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    @NotNull
    @Size(min = 2)
    private String explanation;

}
