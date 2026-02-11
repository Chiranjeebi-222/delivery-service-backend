package com.deliveryservice.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reels")
public class ReelController {

    @Autowired
    private ReelRepository reelRepository;

    @Autowired
    private ReelMetadataRepository metadataRepository;

    // POST: http://localhost:8081/api/reels/create (For Android/Tester)
    @PostMapping("/create")
    @Transactional
    public ResponseEntity<Reel> createReel(@RequestBody Reel reel) {
        Reel savedReel = reelRepository.save(reel);
        
        ReelMetadata metadata = new ReelMetadata();
        metadata.setReelId(savedReel.getId());
        metadataRepository.save(metadata);
        
        return new ResponseEntity<>(savedReel, HttpStatus.CREATED);
    }

    // GET: http://localhost:8081/api/reels/all (Works in Browser)
    @GetMapping("/all")
    public List<Reel> getAllReels() {
        return reelRepository.findAll();
    }
}