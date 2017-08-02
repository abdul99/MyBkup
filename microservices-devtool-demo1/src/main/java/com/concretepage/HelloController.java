package com.concretepage;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class HelloController {       
    @RequestMapping("/hello")
    public String helloMsg(Model model) {
    	String msg = "Weslcome to Everyonewwww!";
    	System.out.println("hekl;");
        model.addAttribute("message", msg);
        return "hello123eeesssssxcvvv";
    }
}    
                                