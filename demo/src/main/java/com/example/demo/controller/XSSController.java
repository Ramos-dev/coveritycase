package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class XSSController {

    @RequestMapping(value = "xsssafe")
    @ResponseBody
    public Object xsssafe(@RequestParam(value = "ls") List<Long> ls){

        return "a"+ls;
    }

    @RequestMapping(value = "xss")
    @ResponseBody
    public Object xss(@RequestParam(value = "ls") List<String> ls){

        return "a"+ls;
    }

    @RequestMapping(value = "xsssafe2")
    @ResponseBody
    public Object xsssafe2(@RequestParam(value = "ls") Long ls){

        return ls;
    }
}
