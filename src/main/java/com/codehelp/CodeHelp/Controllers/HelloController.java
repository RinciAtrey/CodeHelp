package com.codehelp.CodeHelp.Controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello, secured world!";
    }
}
