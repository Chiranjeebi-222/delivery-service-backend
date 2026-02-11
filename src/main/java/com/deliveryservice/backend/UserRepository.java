package com.deliveryservice.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // This allows you to find a user by their Firebase ID instead of just the MySQL ID
    User findByFirebaseUid(String firebaseUid); 
}