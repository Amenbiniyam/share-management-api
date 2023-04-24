package com.share.sharemanagementapi.controllers;

import com.share.sharemanagementapi.domains.UserAccount;
import com.share.sharemanagementapi.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;
    // injecting password encryption algorithm
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/api/useraccount")
    public ResponseEntity<?> createUserAccount(@RequestBody UserAccount userAccount) throws Exception {
        try {

            String encodedPassword = passwordEncoder.encode(userAccount.getPassword());
            userAccount.setPassword(encodedPassword);
            UserAccount saveUserAccount =  userAccountService.registerUserAccount(userAccount);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(saveUserAccount);
        }
        catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":" + ex.getMessage() + "}");
        }
    }


    @GetMapping("/api/useraccounts")
    public Iterable<UserAccount> getAllUserAccounts() {
        return userAccountService.getAllUserAccounts();
//        return accountRepository.findAll();
    }

}
