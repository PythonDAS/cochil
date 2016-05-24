package com.cochil.web;

import com.cochil.domain.ingredient.Ingredient;
import com.cochil.domain.ingredient.IngredientForm;
import com.cochil.service.ingredient.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Controller
public class CochilCntrl {

    private Logger logger = LoggerFactory.getLogger(CochilCntrl.class);

    @Autowired
    private IngredientService service;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello, Cochil!";
    }

    @RequestMapping("/inputData")
    public String inputData() {
        return "input";
    }

    @ModelAttribute
    public IngredientForm setUpForm() {
        return new IngredientForm();
    }

    @RequestMapping(value = "/ingredient/save", method = RequestMethod.POST)
    @ResponseBody
    public Ingredient create(@Validated IngredientForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            logger.info("IngredientForm data has error...");
            return null;
        }

        Ingredient ingredient = new Ingredient();
        BeanUtils.copyProperties(form, ingredient);

        return service.save(ingredient);
    }

}
