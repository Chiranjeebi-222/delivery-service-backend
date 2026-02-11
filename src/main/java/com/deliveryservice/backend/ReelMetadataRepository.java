package com.deliveryservice.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelMetadataRepository extends JpaRepository<ReelMetadata, Integer> {
    @Modifying
    @Query("UPDATE ReelMetadata m SET m.viewCount = m.viewCount + 1 WHERE m.reelId = :id")
    void incrementViewCount(Integer id);
}