package com.abdul.springboot.devtools.controller;

import java.time.LocalDateTime;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@RequestMapping("/")
    String index(Model model) {
        model.addAttribute("hello", "Hello! @" + LocalDateTime.now());
        return "index";
    }
}
