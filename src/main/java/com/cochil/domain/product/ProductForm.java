package com.cochil.domain.product;

import com.cochil.domain.ingredient.Ingredient;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Data
public class ProductForm {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;
    private int productCode; // 0: 치약 1: 샴푸
    private List<Ingredient> ingredientList;

}
