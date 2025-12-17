package com.example.llmfortune.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FortuneSession implements Serializable {
    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private int index = 0;

    public FortuneSession(List<String> questions) {
        this.questions = questions;
    }

    public FortuneSession() {}

    public String currentQuestion() {
        if (questions == null || index >= questions.size()) return null;
        return questions.get(index);
    }

    public void answer(String answer) {
        answers.add(answer);
        index++;
    }

    public boolean finished() {
        return questions != null && index >= questions.size();
    }

    public List<String> getQuestions() { return questions; }
    public List<String> getAnswers() { return answers; }
    public int getIndex() { return index; }
    public int getTotal() { return questions == null ? 0 : questions.size(); }
}
