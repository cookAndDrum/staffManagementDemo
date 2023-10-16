package com.teamcs.controllers.admin;

import com.teamcs.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/delete")
@RestController
@CrossOrigin("*")
public class AdminDeleteUserAccountController {
    private final UserAccount userAccount;

    public AdminDeleteUserAccountController(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteAccount (@PathVariable String username) {
        userAccount.userAccountDelete(username);
        return new ResponseEntity<>(String.format("%s is deleted", username), HttpStatus.OK);
    }
}
