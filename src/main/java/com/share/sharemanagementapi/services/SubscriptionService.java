package com.share.sharemanagementapi.services;


import com.share.sharemanagementapi.domains.Shareholder;
import com.share.sharemanagementapi.domains.Subscription;
import com.share.sharemanagementapi.domains.SubscriptionDTO;
import com.share.sharemanagementapi.repositories.ShareholderRepository;
import com.share.sharemanagementapi.repositories.SubscriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    // here we need the repository then we can not instantiate repo here
    //YOU CANNOT DO THIS! ShareholderRepository shareholderRepository = new ShareholderRepository();
    // then we use Singleton Pattern  is who have @annotation
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private ShareholderRepository shareholderRepository;

    public Subscription createSubscription(SubscriptionDTO subscriptionDto) {
        Shareholder shareholder = shareholderRepository.findById(subscriptionDto.getShareholder_id())
                .orElseThrow(() -> new EntityNotFoundException("Shareholder not found"));
        Subscription subscription = new Subscription();
        subscription.setShareholder_id(shareholder);
        subscription.setNumberOf_Share(subscriptionDto.getNumberOf_Share());
        subscription.setSubs_date(subscriptionDto.getSubs_date());
        return subscriptionRepository.save(subscription);
    }
    // this method accept Shareholders Object and return Shareholders
//    public SubscriptionDTO Subscribe(SubscriptionDTO subscription) throws Exception {
//        return subscriptionRepository.save(subscription);
//    }

//    public Iterable<Shareholder> getAll_Shareholders() {
//
//        //Business Logic comes here
//        // E.g. removing pin from being displayed or returned, merging names, filtering ...
//        return shareholderRepository.findAll();
//    }
//    public Shareholder addShareholder (Shareholder shareholder) {
//        return shareholderRepository.save(shareholder);
//    }
    public List<Subscription> getAll_Subscription () {

        return subscriptionRepository.findAll();
    }
}
