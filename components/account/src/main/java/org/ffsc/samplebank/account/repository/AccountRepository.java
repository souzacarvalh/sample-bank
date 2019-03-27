package org.ffsc.samplebank.account.repository;

import org.ffsc.samplebank.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Felipe Carvalho on 2019-03-10.
 */
public interface AccountRepository extends JpaRepository<Account, String> {

}
