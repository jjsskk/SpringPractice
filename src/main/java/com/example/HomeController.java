//package com.example;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class HomeController {
//    @RequestMapping("/")//handler mapping 처리
//    public String homecontroller(){
//
//
//        System.out.println("home~~~");
//        return "redirect:/board/list";
//    }
//
//    @RequestMapping("home")//handler mapping 처리
//    public String home(){
//
//
//        System.out.println("home~~~");
//        return "home";
//    }
//
//    @RequestMapping("list")//handler mapping 처리
//    public String list(Model model){
//
//        System.out.println("list~~~");
//
//        List<String> list = new ArrayList<String>();
//        list.add("실전프로젝트1");
//        list.add("컴퓨터구조");
//        list.add("컴퓨터비전");
//        list.add("이산수학");
//        model.addAttribute("classlist", list);
//        String msg = "2학년 2학기 교과목 리스트";
//        model.addAttribute("title", msg);
//        return "/board/listimg";
//    }
//}
