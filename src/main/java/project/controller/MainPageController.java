package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @GetMapping("/main")
    public String hello() {
        return "main_page";
    }
}