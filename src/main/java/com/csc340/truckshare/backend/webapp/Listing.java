package com.csc340.truckshare.backend.webapp;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.Date;

@Entity
@Table(name = "listing")

public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int listingId;

    private int userId;

    @Nonnull
    private String title;

    @Nullable
    private String details;

    @Temporal(TemporalType.DATE)
    private Date targetDate;

    private String status;

    public Listing() {
    }

    public Listing(int listingId, int userId, String title, String details, Date targetDate, String status) {
        this.listingId = listingId;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.targetDate = targetDate;
        this.status = status;

    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @Nullable
    public String getDetails() {
        return details;
    }

    public void setDetails(@Nullable String details) {
        this.details = details;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}