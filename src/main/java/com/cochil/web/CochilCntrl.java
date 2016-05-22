package com.cochil.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by donghoon on 2016. 5. 22..
 */
@Controller
public class CochilCntrl {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
