package com.csc340.truckshare.backend.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    @Autowired
    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }


    public List<Conversation> getConversationsByUserId(int userId) {
        return conversationRepository.queryByUserId(userId);
    }
    public List<Conversation> getConversationsBetweenUsers(int convId) {
        return conversationRepository.queryByConvId(convId);
    }

    public Conversation saveConversation(Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    public void deleteConversation(int convId) {
        conversationRepository.deleteById(convId);
    }
}
