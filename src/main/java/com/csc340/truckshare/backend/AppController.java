package com.csc340.truckshare.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {

    @GetMapping({"","/", "/home", "/index"})
    public String home(){
        return "redirect:/welcome";
    }
}
