package com.cochil.domain.product;

import com.cochil.domain.ingredient.Ingredient;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Data
@Document(collection = "products")
public class Toothpaste implements Product {

    @Id
    private String _id;
    private ProductCnst productCode;
    private String name;
    private List<Ingredient> ingredientList;

    public Toothpaste() {
        this.productCode = ProductCnst.TOOTHPASTE;
    }

}
