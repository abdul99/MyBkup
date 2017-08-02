package com.abdul.spring.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class GreetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetController.class);

    @RequestMapping(path = "/public",method = RequestMethod.GET)
    public String sayFreeHi() {
        return "Greeting";
    }

    @RequestMapping(path = "/secured",method = RequestMethod.GET)
    public String saySecureHi() {
        return "Secured";
    }

}
