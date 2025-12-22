package com.example.llmfortune.service;

import com.example.llmfortune.entity.FortuneHistory;
import com.example.llmfortune.form.FortuneForm;
import com.example.llmfortune.repository.FortuneHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FortuneService {

    private final FortuneHistoryRepository repo;
    private final Random random = new Random();

    // Yes/Noで答えられる質問の候補（必要なら増やしてOK）
    private static final List<String> YES_NO_QUESTIONS = List.of(
            "今日、やるべきことを終えられる？",
            "今週中に、良い知らせが来る？",
            "今日、新しいことに挑戦してうまくいく？",
            "今の悩みは、1週間以内に軽くなる？",
            "今日、誰かに感謝を伝えると良いことがある？",
            "今の選択は、長期的に見て正しい？",
            "今日は、休むことを優先した方がいい？",
            "今日、直感に従うとうまくいく？",
            "今月、目標に一歩近づける？",
            "今日、連絡しておいた方がいい人がいる？"
    );

    public FortuneService(FortuneHistoryRepository repo) {
        this.repo = repo;
    }

    // フォームで表示する質問一覧
    public List<String> getYesNoQuestions() {
        return YES_NO_QUESTIONS;
    }

    // 入力 → 占い生成（仮） → DB保存
    public FortuneHistory createFortuneAndSave(FortuneForm form) {
        String result = generateResult();
        String message = generateMessage(form, result);

        FortuneHistory history = new FortuneHistory(result, message);
        return repo.save(history);
    }

    public FortuneHistory findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("履歴が見つかりません: id=" + id));
    }

    // ---- 仮の占いロジック（Phase4でLLMに置き換える）----

    private String generateResult() {
        List<String> results = List.of("大吉", "中吉", "小吉", "吉", "末吉");
        return results.get(random.nextInt(results.size()));
    }

    private String generateMessage(FortuneForm form, String result) {
        String name = safe(form.getName());
        String mood = safe(form.getMood());
        String question = safe(form.getQuestion());

        return name + "さんは今「" + mood + "」モード。\n"
                + "質問「" + question + "」に対する結果は【" + result + "】。\n"
                + "Yes/Noで迷うなら、今日は「Yes寄りの行動を小さく1つ」がおすすめ。";
    }

    private String safe(String s) {
        if (s == null) return "";
        return s.trim();
    }
}

