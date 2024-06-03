package com.csc340.truckshare.backend.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {

    @Autowired
    ConversationRepository conversationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public void createConversation(Conversation listing) {
    }

    public List<Conversation> getALlConversations(){
        return conversationRepository.findAll();
    }

    public List<Conversation> getConversationsByUserId(int userId) {
        return conversationRepository.queryByUserId(userId);
    }

    public Conversation saveConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public void deleteConversation(int convId) {
        conversationRepository.deleteById(convId);
    }
}
