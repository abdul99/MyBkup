package com.abdul.springprojects.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
@RequestMapping({"","/"})
public class HomeController {

    @RequestMapping("")
    public String home(){
        return "Hello :: This is app home";
    }

}
