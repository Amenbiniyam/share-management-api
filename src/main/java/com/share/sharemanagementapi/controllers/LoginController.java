package com.share.sharemanagementapi.controllers;

import com.share.sharemanagementapi.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private UserAccountService userAccountService;

//    @PostMapping
//    public ResponseEntity<?> login(@RequestBody UserAccount userAccount) {
//        UserAccount loggedInUser = userAccountService.login(userAccount.getUsername(), userAccount.getPassword());
//        if (loggedInUser != null) {
//            return ResponseEntity.ok(loggedInUser);
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }
}

