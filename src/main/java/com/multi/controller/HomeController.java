package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping({"/", "/home"})  //매퍼 메핑 어댑터 부분
    public String home(Model model){
        model.addAttribute("msg", "Spring Legacy (XML) running!");
        return "home"; // /WEB-INF/views/home.jsp
    }

//    @GetMapping("/message")
//    public String message(Model model){
//        model.addAttribute("msg", "Hello Spring");
//        return "show";
//    }

    @GetMapping("/message")  //매퍼 메핑 어댑터 부분
    public String msg(Model model){
        model.addAttribute("msg", "Hi...");
        return "hi"; // /WEB-INF/views/hi.jsp
    }
}
