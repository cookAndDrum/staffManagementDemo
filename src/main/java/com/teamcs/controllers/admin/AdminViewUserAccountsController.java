package com.teamcs.controllers.admin;

import com.teamcs.entities.UserAccount;
import com.teamcs.repositories.UserAccountRepository;
import com.teamcs.utils.UserAccountDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin/view")
@CrossOrigin("*")
public class AdminViewUserAccountsController {
    private final UserAccount userAccount;

    public AdminViewUserAccountsController(UserAccount user) {
        userAccount = user;
    }

    @GetMapping
    public List<UserAccountDAO> adminViewUserAccounts (){
        return userAccount.allUserAccountsView();
    }
}
