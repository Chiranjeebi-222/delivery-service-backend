package com.deliveryservice.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // POST: http://localhost:8081/api/users/sync (For Android/Tester)
    @PostMapping("/sync")
    public ResponseEntity<User> syncUser(@RequestBody User user) {
        User existingUser = userRepository.findByFirebaseUid(user.getFirebaseUid());
        if (existingUser != null) {
            return ResponseEntity.ok(existingUser);
        }
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    // GET: http://localhost:8081/api/users/all (Works in Browser)
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}