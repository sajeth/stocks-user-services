package com.saji.users.repository;


import com.saji.users.entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<User, java.math.BigInteger> {
    @Query("from User where NAME = ?1")
    Optional<User> findByUserId(String name);
}