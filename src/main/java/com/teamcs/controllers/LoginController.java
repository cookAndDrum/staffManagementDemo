package com.teamcs.controllers;

import com.teamcs.utils.LoginRequest;
import com.teamcs.entities.UserAccount;
import com.teamcs.repositories.UserAccountRepository;
import com.teamcs.repositories.UserProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final UserAccountRepository userAccountRepository;
    private final UserProfileRepository userProfileRepository;

    public LoginController(UserAccountRepository userAccountRepository, UserProfileRepository userProfileRepository) {
        this.userAccountRepository = userAccountRepository;
        this.userProfileRepository = userProfileRepository;
    }

    // Not sure if I am allowed to use the temporary object created to carry request body
    // Should use custom Exception
    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        if (request == null || request.getUsername().isEmpty()
                || request.getPassword().isEmpty())
            throw new IllegalStateException ("Username or Password is Empty");

        UserAccount loginUser = UserAccount.userAccountLogin(
                userAccountRepository, userProfileRepository, request
        );

        if (loginUser.isAccountSuspended())
            throw new IllegalStateException("User is suspended");

        return new ResponseEntity<>("Login Success", HttpStatus.OK);
    }
}
