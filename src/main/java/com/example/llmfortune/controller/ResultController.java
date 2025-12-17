package com.example.llmfortune.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResultController {

    @PostMapping("/result")
    public String showResult(
            @RequestParam String q0, @RequestParam String a0,
            @RequestParam String q1, @RequestParam String a1,
            @RequestParam String q2, @RequestParam String a2,
            Model model
    ) {
        List<String> questions = List.of(q0, q1, q2);
        List<String> answers   = List.of(a0, a1, a2);

        model.addAttribute("questions", questions);
        model.addAttribute("answers", answers);

        // ダミー結果（Week3でLLM置換）
        model.addAttribute("fortuneText", "3問に答えたあなたは、今日は「継続」が運を呼びます。");

        return "result";
    }
}

