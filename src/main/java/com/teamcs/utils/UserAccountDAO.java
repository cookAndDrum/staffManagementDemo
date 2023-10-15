package com.teamcs.utils;

import com.teamcs.entities.UserAccount;

public class UserAccountDAO {
    private String name;
    private String username;
    private String email;

    public UserAccountDAO() {
        super();
    }

    public UserAccountDAO(UserAccount userAccount) {
        this.name = userAccount.getName();
        this.username = userAccount.getUsername();
        this.email = userAccount.getEmail();
    }

    public UserAccountDAO(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
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
