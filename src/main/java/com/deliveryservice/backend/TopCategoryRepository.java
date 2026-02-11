package com.deliveryservice.backend;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TopCategoryRepository extends JpaRepository<TopCategory, Integer> {
    List<TopCategory> findByCityid(Integer cityid);
}