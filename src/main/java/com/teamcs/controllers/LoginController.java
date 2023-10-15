package com.teamcs.controllers;

import com.teamcs.entities.LoginRequest;
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

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        boolean loginStatus = UserAccount.userAccountLogin();

        String message = "The login is not implemented yet " + request.getUsername() + " " +
                request.getPassword();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
