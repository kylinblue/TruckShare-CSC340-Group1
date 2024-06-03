package com.csc340.truckshare.backend.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/webapp/listings")


public class ListingController {

    @Autowired UserService userService;
    @Autowired ListingService listingService;
    @Autowired ConversationService conversationService;

    @GetMapping("/all")
    public String getAllListings(Model model){
        model.addAttribute("allListings", listingService.getAllListings());
        return "all-Listings";
    }

    @GetMapping("/findListingByUserId")
    public String findListingByUserId(){
        return "find-Listing-By-User-Id";
    }

}

