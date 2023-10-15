package com.teamcs.repositories;

import com.teamcs.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    Optional<UserAccount> findByUsername(String username);
    Optional<UserAccount> findByUsernameAndPassword(String username, String password);
    Optional<UserAccount> findByEmail(String email);

}
