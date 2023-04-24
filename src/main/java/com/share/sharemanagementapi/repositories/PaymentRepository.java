package com.share.sharemanagementapi.repositories;

import com.share.sharemanagementapi.domains.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    void deleteById(Long id);
    Optional<Payment> findById (Long id);
}
