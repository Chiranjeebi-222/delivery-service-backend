package com.deliveryservice.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {
    // Spring Boot automatically creates the SQL for this!
    List<Store> findByCityId(Integer cityId);
}