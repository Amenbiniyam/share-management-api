package com.share.sharemanagementapi.repositories;

import com.share.sharemanagementapi.domains.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    void deleteById(Long id);
    Optional<Subscription> findById (Long id);

}
