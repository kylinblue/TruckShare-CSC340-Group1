package com.csc340.truckshare.backend.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/") // figure out where to map the user to

public class UserController {
    @Autowired UserService userService;
    @Autowired ListingService listingService;
    @Autowired ConversationService conversationService;

    @GetMapping("/login")
    public String userLogin(){
        return "user-login";
    }

    @GetMapping("/signup")
    public String userSignup(){
        return "user-signup";
    }

    @PostMapping("/auth")
    public String userAuth(User user){
        if (user.getUserType()) {
            return "admin-home";
        }
        else return "user-home";
    }
}
