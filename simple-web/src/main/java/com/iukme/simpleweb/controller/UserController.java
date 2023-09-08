package com.iukme.simpleweb.controller;

import com.iukme.simpleweb.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;
    
    @GetMapping("/page")
    public String page(@RequestParam(value = "name") String name){
        return userFeign.page(name);
    }
}
