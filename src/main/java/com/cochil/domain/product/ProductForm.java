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
public class ProductForm {

    private ProductCnst productCode; // 0: 치약 1: 샴푸
    private String name;
    private List<Ingredient> ingredientList;

}
