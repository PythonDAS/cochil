package com.cochil.domain.ingredient;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Document(collection = "ingredients")
@Data
@NoArgsConstructor
public class Ingredient {

    @Id
    private String id;
    private String name;
    private String explanation;

    public Ingredient(String name, String explanation) {
        this.name = name;
        this.explanation = explanation;
    }

}
