package com.example.llmfortune.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FortuneHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String result;   // 占い結果（大吉など）

    @Column(length = 1000)
    private String message;  // LLMの文章

    private LocalDateTime createdAt = LocalDateTime.now();

    // JPA用（必須）
    protected FortuneHistory() {}

    // 便利コンストラクタ（Phase1の保存テスト用）
    public FortuneHistory(String result, String message) {
        this.result = result;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    // ----- getters -----
    public Long getId() { return id; }
    public String getResult() { return result; }
    public String getMessage() { return message; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // ----- setters -----
    public void setResult(String result) { this.result = result; }
    public void setMessage(String message) { this.message = message; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
