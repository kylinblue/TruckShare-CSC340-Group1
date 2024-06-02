package com.csc340.truckshare.backend.webapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository <Listing, Integer> {
        @Query(value = "select * from listing where user_id =?1", nativeQuery = true)
        List<Listing> queryByUserId(int userId);
}
