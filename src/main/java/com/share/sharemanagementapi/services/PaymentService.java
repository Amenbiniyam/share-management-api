package com.share.sharemanagementapi.services;

import com.share.sharemanagementapi.domains.Payment;
import com.share.sharemanagementapi.domains.PaymentDTO;
import com.share.sharemanagementapi.domains.Subscription;
import com.share.sharemanagementapi.repositories.PaymentRepository;
import com.share.sharemanagementapi.repositories.SubscriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    // here we need the repository then we can not instantiate repo here
    //YOU CANNOT DO THIS! ShareholderRepository shareholderRepository = new ShareholderRepository();
    // then we use Singleton Pattern  is who have @annotation
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(PaymentDTO paymentDTO) {
        Subscription subscription = subscriptionRepository.findById(paymentDTO.getSubscription_id())
                .orElseThrow(() -> new EntityNotFoundException("Subscription not found"));
        Payment payment = new Payment();
        //payment.setId(subscription);
        payment.setPaid_amount(paymentDTO.getPaid_amount());
        payment.setWeighted(paymentDTO.getWeighted());
        payment.setPaid_date(paymentDTO.getPaid_date());
        return paymentRepository.save(payment);
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
