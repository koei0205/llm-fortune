package com.example.llmfortune.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuestionController {

    @GetMapping({"/", "/question"})
    public String showQuestions(Model model) {

        List<String> questions = List.of(
                "最近、新しいことに挑戦しましたか？",
                "今日は誰かに感謝を伝えましたか？",
                "今、やりたいことを一つ思い浮かべましたか？"
        );

        model.addAttribute("questions", questions);
        return "question";
    }
}
