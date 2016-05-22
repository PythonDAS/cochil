package com.cochil.domain.ingredient;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Document(collection = "ingredients")
@Data
public class Ingredient {

    @Id
    private String _id;
    private String name;
    private String explanation;

}
