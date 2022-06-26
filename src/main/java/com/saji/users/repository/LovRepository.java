package com.saji.users.repository;

import com.saji.users.entities.Lov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface LovRepository extends JpaRepository<Lov, BigInteger> {
    @Modifying
    @Query("update Lov set logicalDeleteIn='Y' where id = ?1")
    void deleteLov(BigInteger id);

    @Query("from Lov where type = ?1")
    List<Lov> listAll(String type);
}