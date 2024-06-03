package com.csc340.truckshare.backend.webapp;

import jakarta.security.enterprise.credential.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    ListingRepository listingRepository;
    ConversationRepository conversationRepository;

    public User getUserByUserName(String username, Password password) {
        User user = userRepository.findByUsername(username);
        // Need to implement password hash, currently plain text
        if (user.getUserPassword() == password) {
            return user;
        }
        return null;
    }

    public int createUser(User user) {
        if (getUserByUserName(user.getUsername(), user.getUserPassword())==null)
        {
            userRepository.save(user);
            return user.getUserId();
        }
        else return -1;
    }

    public User getUserByUserId(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteUserById(int userId) {
        if (this.listingRepository != null) {
            List<Listing> listingToDelete = listingRepository.queryByUserId(userId);
        }
    }
}
