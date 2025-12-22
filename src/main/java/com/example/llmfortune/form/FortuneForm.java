package com.example.llmfortune.form;

public class FortuneForm {

    private String name;       // 名前
    private String mood;       // 気分

    // ユーザーが選んだ質問（Yes/Noで答えられる質問文そのものを入れる）
    private String question;

    public FortuneForm() {
    }

    public String getName() {
        return name;
    }

    public String getMood() {
        return mood;
    }

    public String getQuestion() {
        return question;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
