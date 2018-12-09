package com.demo.app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class Welcome {    
    @RequestMapping("/")
    public String index() {
        return "Salut les Gens !!";
    }

}
