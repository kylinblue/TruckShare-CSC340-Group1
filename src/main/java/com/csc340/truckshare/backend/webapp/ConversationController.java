package com.csc340.truckshare.backend.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequestMapping("/webapp/conversations")


public class ConversationController {
    @Autowired UserService userService;
    @Autowired ListingService listingService;
    @Autowired ConversationService conversationService;


    @GetMapping("/new")
    public RedirectView createConversation(Conversation conversation, RedirectAttributes attributes) {
        conversationService.createConversation(conversation);
        attributes.addFlashAttribute("message", "New conversation started!");
        return new RedirectView("/webapp/user/userid/");
    }

    @GetMapping("/all")
    public String getALlConversations(Model model){
        model.addAttribute("allConversations", conversationService.getALlConversations());
        return "all-Conversations";
    }



    @GetMapping("/by/user/id")
    public RedirectView getConversationsByUserId(int id, Model model){
        model.addAttribute("conversation", conversationService.getConversationsByUserId(id));
        return new RedirectView("/webapp/user/userid/");
    }




    @PostMapping("/save")
    public RedirectView saveConversation(Conversation conversation,RedirectAttributes attributes){
        conversationService.saveConversation(conversation);
        attributes.addFlashAttribute("message","Conversation Saved");
        return new RedirectView("/webapp/user/userid/");
    }

    @PostMapping("/delete")
    public RedirectView deleteConversation(@RequestParam("convId") int id, RedirectAttributes attributes) {
        conversationService.deleteConversation(id);
        attributes.addFlashAttribute("message", "Conversation deleted successfully!");
        return new RedirectView("/webapp/user/userid/");
    }
}
