package com.teamcs.utils;

import com.teamcs.entities.UserAccount;
import com.teamcs.entities.UserProfile;

public class UserAccountDAO {
    private String name;
    private String username;
    private String email;
    private UserProfile profile;

    public UserAccountDAO() {
        super();
    }

    public UserAccountDAO(UserAccount userAccount) {
        this.name = userAccount.getName();
        this.username = userAccount.getUsername();
        this.email = userAccount.getEmail();
        this.profile = userAccount.getUserProfile();
    }

    public UserAccountDAO(String name, String username, String email, UserProfile profile) {
        this.name = name;
        this.username = username;
        this.profile = profile;
        this.email = email;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
