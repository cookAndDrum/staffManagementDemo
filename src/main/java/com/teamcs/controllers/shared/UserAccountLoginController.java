package com.teamcs.controllers.shared;

import com.teamcs.entities.UserAccount;
import com.teamcs.utils.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class UserAccountLoginController {
    private final UserAccount userAccount;

    public UserAccountLoginController(UserAccount user) {
        userAccount = user;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        if (request == null || request.getUsername().isEmpty()
                || request.getPassword().isEmpty())
            throw new IllegalStateException ("Username or Password is Empty");

        UserAccount loginUser = userAccount.userAccountLogin(request);

        if (loginUser.isAccountSuspended())
            throw new IllegalStateException("User is suspended");

        return new ResponseEntity<>("Login Success", HttpStatus.OK);
    }
}
