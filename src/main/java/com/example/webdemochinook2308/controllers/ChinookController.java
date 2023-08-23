package com.example.webdemochinook2308.controllers;

import com.example.webdemochinook2308.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ChinookController {

    private EmployeeService es;

    @GetMapping("/")
    public String index(Model model) {
//        model.addAttribute("employees", es.getEmployees());
        model.addAttribute("employees", es.getInfo());
        return "info";
    }
}
