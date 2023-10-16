package com.teamcs.controllers.shared;

import com.teamcs.entities.UserAccount;
import com.teamcs.utils.UserAccountDAO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/owner/userAccount")
@CrossOrigin("*")
public class UserViewOwnAccountController {
    private final UserAccount userAccount;

    public UserViewOwnAccountController(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    // Use path, proper way
    @GetMapping("/{username}")
    public UserAccountDAO ownerViewOwnAccount (@PathVariable String username) {
        return userAccount.userAccountView(username);
    }

    // Use post request body
    @PostMapping
    public UserAccountDAO ownerViewOwnAccount (@RequestBody Map<String, String> requestBody) {
        return userAccount.userAccountView(requestBody.get("username"));
    }
}
