package com.cochil.web;

import com.cochil.service.ingredient.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String inputData(Model model) {
        String count = "Count: " + service.count().toString();
        model.addAttribute("count", count);
        logger.info("ingredient count: {}", count);
        return "input";
    }

}
