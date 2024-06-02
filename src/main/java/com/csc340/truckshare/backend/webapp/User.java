package com.csc340.truckshare.backend.webapp;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.security.enterprise.credential.Password;
import jakarta.persistence.*;

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private int userType;

    private Password userPassword;

    @Nonnull
    private String title;

    @Nullable
    private String details;

    public User() {}

    public User(int userId, int userType, Password userPassword, String title, String details){
        this.userId = userId;
        this.userType = userType;
        this.userPassword = userPassword;
        this.title = title;
        this.details = details;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
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
}
