package com.cochil.web;

import com.cochil.domain.product.Product;
import com.cochil.domain.product.ProductForm;
import com.cochil.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@RestController
@RequestMapping(value = "/product")
public class ProductCntrl {

    private Logger logger = LoggerFactory.getLogger(ProductCntrl.class);

    @Autowired
    private ProductService service;

    @ModelAttribute
    public ProductForm setUpForm() {
        return new ProductForm();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Product save(@Validated ProductForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError error : errorList) {
                logger.info(error.toString());
            }
            logger.info("ProductForm data has error...");
            return null;
        }

        Product product = new Product();
        BeanUtils.copyProperties(form, product);

        return service.save(product);
    }

    @RequestMapping(value = "/prCount", method = RequestMethod.POST)
    public String count() {
        return "Count: " + service.count();
    }

}
