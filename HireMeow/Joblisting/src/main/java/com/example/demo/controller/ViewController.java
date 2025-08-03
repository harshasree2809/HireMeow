package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // Home page
    @GetMapping("/")
    public String homePage() {
        return "index";  // Maps to index.html in templates
    }

    // Get Job page
    @GetMapping("/hire")
    public String hirePage() {
        return "Hire";  // Maps to Hire.html in templates
    }

    // Add Job page
    @GetMapping("/postjob")
    public String postJobPage() {
        return "jobpost";  // Maps to jobpost.html in templates
    }
}
