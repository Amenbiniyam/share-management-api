package com.share.sharemanagementapi.utils;

import com.share.sharemanagementapi.repositories.ShareholderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DuplicationCheck {
    @Autowired
    private ShareholderRepository shareholderRepository;
    public static Boolean findPhoneNumber(String phone) {
        //Boolean result = findPhoneNumber(phone);
        if(phone == "+251911825671") {
            return true;
        }
        return false;

    }
}
