package com.example.llmfortune.controller;

import com.example.llmfortune.entity.FortuneHistory;
import com.example.llmfortune.form.FortuneForm;
import com.example.llmfortune.service.FortuneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fortune")
public class FortuneController {

    private final FortuneService fortuneService;

    public FortuneController(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    // 入力フォーム
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("fortuneForm", new FortuneForm());
        model.addAttribute("questions", fortuneService.getYesNoQuestions());
        return "fortune-form";
    }

    // 占う → DB保存 → 結果ページへリダイレクト（PRG）
    @PostMapping
    public String submit(@ModelAttribute FortuneForm fortuneForm) {
        FortuneHistory saved = fortuneService.createFortuneAndSave(fortuneForm);
        return "redirect:/fortune/result/" + saved.getId();
    }

    // 結果表示（DBから読み直す）
    @GetMapping("/result/{id}")
    public String showResult(@PathVariable Long id, Model model) {
        FortuneHistory history = fortuneService.findById(id);
        model.addAttribute("history", history);
        return "fortune-result";
    }
}
