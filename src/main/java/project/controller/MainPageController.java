package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainPageController {
    @GetMapping("/profiles")
    public String profilesPage() {
        return "profiles_page";
    }

    @GetMapping("/calculator/window")
    public String calculatorWindowPage() {
        return "calculator-window_page";
    }

    @GetMapping("/connections")
    public String connectionsPage() {
        return "connections_page";
    }
}
