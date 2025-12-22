package com.example.llmfortune.repository;

import com.example.llmfortune.entity.FortuneHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FortuneHistoryRepository extends JpaRepository<FortuneHistory, Long> {
}