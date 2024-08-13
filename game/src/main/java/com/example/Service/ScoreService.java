package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Entity.ScoreEntity;
import com.example.Repo.ScoreRepo;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepo scoreRepo;

    public ScoreEntity saveScore(ScoreEntity score) {
        return scoreRepo.save(score);
    }
    
    public List<ScoreEntity> getScore() {
        return scoreRepo.findAll();
    }
}
