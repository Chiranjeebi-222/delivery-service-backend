package com.deliveryservice.backend;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
    List<Gallery> findBySid(Integer sid);
}