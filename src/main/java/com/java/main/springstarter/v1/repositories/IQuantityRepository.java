package com.java.main.springstarter.v1.repositories;

import com.java.main.springstarter.v1.models.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuantityRepository extends JpaRepository<Quantity, Long> {
}
