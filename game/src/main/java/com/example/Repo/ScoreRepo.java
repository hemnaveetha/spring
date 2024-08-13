package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Entity.ScoreEntity;

@Repository
public interface ScoreRepo extends JpaRepository<ScoreEntity, Integer> {
}
