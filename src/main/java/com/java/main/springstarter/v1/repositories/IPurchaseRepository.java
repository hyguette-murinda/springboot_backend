package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseRepository extends JpaRepository<Purchase, Long> {

}