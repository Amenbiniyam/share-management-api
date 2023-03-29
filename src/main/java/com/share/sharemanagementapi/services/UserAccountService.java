package com.share.sharemanagementapi.services;

import com.share.sharemanagementapi.domains.UserAccount;
import com.share.sharemanagementapi.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    // here we need the repository then we can not instantiate repo here
    //YOU CANNOT DO THIS! ShareholderRepository shareholderRepository = new ShareholderRepository();
    // then we use Singleton Pattern  is who have @annotation
    @Autowired
    private UserAccountRepository userAccountRepository;

    // this method accept Shareholders Object and return Shareholders
    public UserAccount registerUserAccount(UserAccount userAccount) throws Exception {
       if(userAccount == null){
           throw new Exception("Phone Number is Exist");
       }
        return userAccountRepository.save(userAccount);

    }

    public Iterable<UserAccount> getAllUserAccounts() {

        //Business Logic comes here
        // E.g. removing pin from being displayed or returned, merging names, filtering ...
        return userAccountRepository.findAll();
    }
}
