package com.csc340.truckshare.backend.webapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    @Query(value = "select * from Conversation where user_id =?1", nativeQuery = true)
    List<Conversation> queryByUserId(int userId);
}
