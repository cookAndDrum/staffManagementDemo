package com.teamcs.utils;

import com.teamcs.entities.UserAccount;

public class UserAccountDAO {
    private String name;
    private String username;
    private String email;
    private String profile;

    public UserAccountDAO() {
        super();
    }

    public UserAccountDAO(UserAccount userAccount) {
        this.name = userAccount.getName();
        this.username = userAccount.getUsername();
        this.email = userAccount.getEmail();
        this.profile = userAccount.getUserProfile().getProfile();
    }

    public UserAccountDAO(String name, String username, String email, String profile) {
        this.name = name;
        this.username = username;
        this.profile = profile;
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
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
