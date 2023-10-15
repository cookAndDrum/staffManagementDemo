package com.teamcs.controllers.admin;

import com.teamcs.repositories.UserAccountRepository;
import com.teamcs.repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/view")
@CrossOrigin("*")
public class adminViewUsersController {
    private final UserAccountRepository userAccountRepository;
    private final UserProfileRepository userProfileRepository;

    public adminViewUsersController(UserAccountRepository userAccountRepository, UserProfileRepository userProfileRepository) {
        this.userAccountRepository = userAccountRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @GetMapping("/")
    public String helloFromAdminController () {
        return "Hello world";
    }
}
