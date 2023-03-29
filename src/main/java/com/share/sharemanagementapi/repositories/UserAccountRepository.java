package com.share.sharemanagementapi.repositories;

import com.share.sharemanagementapi.domains.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
