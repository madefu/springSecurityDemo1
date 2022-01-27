package com.madefu.spd1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple/")
public class SimpleController {

    @RequestMapping("/add")
    public String add(String name){

        return "hello,"+name;
    }
}
