package com.demo.rater;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Inscription {
    @RequestMapping("/Inscription")
    public String inscription() {
        return "Inscription";
    }
    

}

