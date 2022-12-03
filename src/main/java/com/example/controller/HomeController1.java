package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HomeController1 {
    @RequestMapping("/")//handler mapping 처리
    public String homecontroller1(Model model){

        System.out.println("home~~~");
        model.addAttribute("serverTime",new Date());
        return "home";
    }
}
