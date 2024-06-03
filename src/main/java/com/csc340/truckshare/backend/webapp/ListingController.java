package com.csc340.truckshare.backend.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/webapp/listings")


public class ListingController {

    RedirectAttributes attributes;
    @Autowired UserService userService;
    @Autowired ListingService listingService;
    @Autowired ConversationService conversationService;

    @GetMapping("/all")
    public String getAllListings(Model model){
        model.addAttribute("alllistings", listingService.getAllListings());
        return "all-listings";
    }
// @GetMapping("/taskid/{taskId}")
//    public String getTaskByTaskId(@PathVariable int taskId, Model model) {
//        model.addAttribute("task", taskService.getTaskByTaskId(taskId));
//        return "task-detail";

    //
    @GetMapping("/findlistingbyuserid")
    public String findListingByUserId(@PathVariable int userId, Model model){
        model.addAttribute("listing", listingService.findListingByUserId(userId));
        return "find-listing-by-user-id";
    }

    @PostMapping("/createlisting")
    public RedirectView createListing(Listing listing, RedirectAttributes attributes) {
        listingService.createListing(listing);
        attributes.addFlashAttribute("message", "Listing created successfully!");
        return new RedirectView("/webapp/user/userid/");
                                                            //fix address!!
    }

    @PostMapping("/updateListing")
    public RedirectView updateListing(@RequestParam("listingid") int id, Listing listing, RedirectAttributes attributes) {
        listingService.updateListing(id, listing);
        attributes.addFlashAttribute("message", "Listing updated successfully!");
        return new RedirectView("/webapp/user/userid/");
                                                             //fix address!!
    }

    @PostMapping("/deletelisting")
    public RedirectView deleteListing(@RequestParam("listingid") int id, RedirectAttributes attributes) {
        listingService.deleteListing(id);
        attributes.addFlashAttribute("message", "Listing deleted successfully!");
        return new RedirectView("/webapp/user/userid/");
    }
}

