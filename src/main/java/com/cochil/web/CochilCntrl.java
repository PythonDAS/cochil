package com.cochil.web;

import com.cochil.domain.ingredient.Ingredient;
import com.cochil.domain.manufacturer.Manufacturer;
import com.cochil.domain.product.Product;
import com.cochil.service.ingredient.IngredientService;
import com.cochil.service.manufacturer.ManufacturerService;
import com.cochil.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Controller
public class CochilCntrl {

    private Logger logger = LoggerFactory.getLogger(CochilCntrl.class);

    @Autowired
    private IngredientService igService;
    @Autowired
    private ManufacturerService mfService;
    @Autowired
    private ProductService prService;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello, Cochil!";
    }

    @RequestMapping("/inputData")
    public String inputData(Model model) {
        String igCount = "Count: " + igService.count().toString();
        String mfCount = "Count: " + mfService.count().toString();
        String prCount = "Count: " + prService.count().toString();
        model.addAttribute("igCount", igCount);
        model.addAttribute("mfCount", mfCount);
        model.addAttribute("prCount", prCount);
        logger.info("Count: {}", igCount);
        logger.info("Count: {}", mfCount);
        logger.info("Count: {}", prCount);
        return "input";
    }

    @RequestMapping("/listData")
    public String listData(@PageableDefault Pageable pageable, Model model) {
        String igCount = "Count: " + igService.count().toString();
        String mfCount = "Count: " + mfService.count().toString();
        String prCount = "Count: " + prService.count().toString();
        model.addAttribute("igCount", igCount);
        model.addAttribute("mfCount", mfCount);
        model.addAttribute("prCount", prCount);

        Page<Ingredient> ingredients = igService.findAll(pageable);
        Page<Manufacturer> manufacturers = mfService.findAll(pageable);
        Page<Product> products = prService.findAll(pageable);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("manufacturers", manufacturers);
        model.addAttribute("products", products);

        return "list";
    }

}
