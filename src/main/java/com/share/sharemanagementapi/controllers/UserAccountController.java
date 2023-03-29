package com.share.sharemanagementapi.controllers;

import com.share.sharemanagementapi.domains.UserAccount;
import com.share.sharemanagementapi.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;
    @PostMapping("/api/useraccount")
    public ResponseEntity<?> createShareholder(@RequestBody UserAccount userAccount) throws Exception {
        try {
            UserAccount saveShareholder =  userAccountService.registerUserAccount(userAccount);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(saveShareholder);
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
