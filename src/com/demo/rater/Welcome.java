package com.demo.rater;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class Welcome {    
    @RequestMapping("/")
    public String index() {
        return "<h2>Hey Softeamiens !!</h2>";
    }

}
