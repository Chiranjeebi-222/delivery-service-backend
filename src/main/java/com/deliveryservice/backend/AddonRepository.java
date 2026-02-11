package com.deliveryservice.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AddonRepository extends JpaRepository<Addon, Integer> {
    // This MUST match the variable name 'itemid' in your Addon.java entity
    List<Addon> findByItemid(Integer itemid);
}