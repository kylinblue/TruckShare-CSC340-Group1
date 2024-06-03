package com.csc340.truckshare.backend.webapp;

import jakarta.security.enterprise.credential.Password;
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

    @GetMapping("/login") // the login page
    public String userLogin(){
        return "user-login";
    }

    @PostMapping("/signup") // aka create
    public String userSignup(User user){
        if (userService.createUser(user)==-1){
            return "user-exists";
        }
        return "user-signup";
    }
    // need to implement username check

    @PostMapping("/auth")
    public String userAuth(String username, Password password){
        User user = userService.getUserByUserName(username, password);
        if (user == null)
        {
            return "auth-failure";
        }
        else if (user.getUserType()) {
            return "admin-home";
        }
        else return "user-home";
    }

    @GetMapping("/logout")
    public String userLogout(){ return "user-login"; }
}
