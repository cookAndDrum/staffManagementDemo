package com.teamcs.controllers.owner;

import com.teamcs.entities.UserAccount;
import com.teamcs.repositories.UserAccountRepository;
import com.teamcs.repositories.UserProfileRepository;
import com.teamcs.utils.UserAccountDAO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/owner/userAccount")
public class ownerViewOwnAccountController {
    private final UserAccountRepository userAccountRepository;

    public ownerViewOwnAccountController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    // Use path, proper way
    @GetMapping("/{username}")
    public UserAccountDAO ownerViewOwnAccount (@PathVariable String username) {
        // Could check if user is owner, though seems not necessary
        UserAccountDAO owner = UserAccount.userAccountView(userAccountRepository, username);
        if (!owner.getProfile().equals("OWNER"))
            throw new IllegalStateException("User is not OWNER!");
        return owner;
    }

    // Use post request body
    @PostMapping
    public UserAccountDAO ownerViewOwnAccount (@RequestBody Map<String, String> requestBody) {
        // Could check if user is owner
        return UserAccount.userAccountView(userAccountRepository, requestBody.get("username"));
    }
}
