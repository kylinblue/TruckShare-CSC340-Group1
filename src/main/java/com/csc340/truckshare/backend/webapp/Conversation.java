package com.csc340.truckshare.backend.webapp;


import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int convId;

    private int userId;

    @Nonnull
    private String title;

    @Nullable
    private String details;

    private boolean supportNeeded;

    public Conversation() {
    }

    public Conversation(int convId, int userId, String title, String details, Boolean supportNeeded) {
        this.convId = convId;
        this.userId = userId;
        this.title = title;
        this.details = details;
        this.supportNeeded = supportNeeded;
    }

    public int getConvId() {
        return convId;
    }

    public void setConvId(int convId) {
        this.convId = convId;
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

    public boolean isSupportNeeded() {
        return supportNeeded;
    }

    public void setSupportNeeded(boolean supportNeeded) {
        this.supportNeeded = supportNeeded;
    }
}