package com.csc340.truckshare.backend.webapp;

import jakarta.annotation.Nonnull;
import jakarta.security.enterprise.credential.Password;
import jakarta.persistence.*;
import jakarta.security.enterprise.identitystore.*;

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private boolean isAdmin;

    @Nonnull
    private String username;

    private Password userPassword;

    public User() {}

    public User(int userId, boolean isAdmin, Password userPassword, String username, String details){
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.userPassword = userPassword;
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean getUserType() {
        return isAdmin;
    }

    public void setUserType(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Nonnull
    public String getUsername() {
        return username;
    }

    public void setUsername(@Nonnull String username) {
        this.username = username;
    }

    // plain text password!
    public void setUserPassword(Password userPassword) {
        this.userPassword = userPassword;
    }

    public Password getUserPassword() {
        return userPassword;
    }

    // password hash, to be implemented
    /*public PasswordHash getUserPasswordHash() {
        return this.userPassword.hashCode();
    }*/

}
