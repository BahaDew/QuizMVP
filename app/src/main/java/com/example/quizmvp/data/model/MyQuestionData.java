package com.example.quizmvp.data.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyQuestionData {
    private final String question;
    private final String answer;
    private final List<String> variants = new ArrayList<>();

    public MyQuestionData(String question, String answer, String... variants) {
        this.question = question;
        this.answer = answer;
        this.variants.addAll(Arrays.asList(variants));
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getVariants() {
        Collections.shuffle(variants);
        return variants;
    }
}
