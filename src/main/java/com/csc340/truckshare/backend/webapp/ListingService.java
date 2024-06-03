package com.csc340.truckshare.backend.webapp;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListingService {
    @Autowired
    ListingRepository listingRepository;
    ConversationRepository conversationRepository;
    UserRepository userRepository;

    public List<Listing> getAllListings() {

    }


    public void createListing(Listing listing) {
    }

    public void updateListing(int id, Listing listing) {
    }

    public void deleteListing(int id) {
    }

    public Object findListingByUserId(int userId) {
    }
}
