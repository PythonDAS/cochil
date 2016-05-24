package com.cochil.web;

import com.cochil.domain.manufacturer.Manufacturer;
import com.cochil.domain.manufacturer.ManufacturerForm;
import com.cochil.service.manufacturer.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by donghoon on 2016. 5. 25..
 */
@RestController
@RequestMapping(value = "/manufacturer")
public class ManufacturerCntrl {

    private Logger logger = LoggerFactory.getLogger(ManufacturerCntrl.class);

    @Autowired
    private ManufacturerService service;

    @ModelAttribute
    public ManufacturerForm setUpForm() {
        return new ManufacturerForm();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Manufacturer save(@Validated ManufacturerForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            logger.info("ManufacturerForm data has error...");
            return null;
        }

        Manufacturer manufacturer = new Manufacturer();
        BeanUtils.copyProperties(form, manufacturer);

        return service.save(manufacturer);
    }

    @RequestMapping(value = "/mfCount", method = RequestMethod.POST)
    public String count() {
        return "Count: " + service.count();
    }

}
