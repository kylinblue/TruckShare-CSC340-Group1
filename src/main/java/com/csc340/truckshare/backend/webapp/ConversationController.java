package com.csc340.truckshare.backend.webapp;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/webapp/conversations")


public class ConversationController {
    @Autowired UserService userService;
    @Autowired ListingService listingService;
    @Autowired ConversationService conversationService;


    @GetMapping("/all")
    public List<Conversation>getAllConversation() {
        return conversationService.getALlConversations();

    }

    @GetMapping("/byUserID")
    public List<Conversation>getConversationsByUserId(int userId){
        return conversationService.getConversationsByUserId(userId);
    }

    @PostMapping("/save")
    public Conversation saveConversation(@RequestBody Conversation conversation){
        return conversationService.saveConversation(conversation);
    }

    @DeleteMapping("/{convId}")
    public void deleteConversation(@PathVariable int convId){
        conversationService.deleteConversation(convId);
    }
}
