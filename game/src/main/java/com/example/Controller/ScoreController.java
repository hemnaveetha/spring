package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Entity.ScoreEntity;
import com.example.Service.ScoreService;
import com.example.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserService userService;

    @PostMapping("/addScore")
    public ResponseEntity<ScoreEntity> addScore(@RequestParam int userId, @RequestBody ScoreEntity score) {
        score.setUser(userService.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found")));
        ScoreEntity savedScore = scoreService.saveScore(score);
        return ResponseEntity.ok(savedScore);
    }
    
    @GetMapping("/getScore")
    public ResponseEntity<ScoreEntity> getScore() {
        return (ResponseEntity<ScoreEntity>) scoreService.getScore();
    }
    
    
    
}
