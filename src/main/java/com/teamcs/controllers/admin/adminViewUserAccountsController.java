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
public class adminViewUserAccountsController {
    private final UserAccountRepository userAccountRepository;
    public adminViewUserAccountsController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    // User Profile is not included, can be updated in the DAO object.
    @GetMapping
    public List<UserAccountDAO> adminViewUserAccounts (){
        return UserAccount.allUserAccountsView(userAccountRepository);
    }
}
