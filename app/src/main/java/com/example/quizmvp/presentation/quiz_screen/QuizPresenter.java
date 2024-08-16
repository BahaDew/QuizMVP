package com.example.quizmvp.presentation.quiz_screen;

import android.util.Log;

import com.example.quizmvp.data.model.MyQuestionData;

import java.util.ArrayList;
import java.util.List;

public class QuizPresenter implements QuizContract.Presenter {
    private final QuizContract.View view;
    private QuizContract.Model model;
    private final List<MyQuestionData> data;
    private int currentTest;
    private int testCount;
    private int correctTestCount;
    private final List<String> variants = new ArrayList<>();

    public QuizPresenter(QuizContract.View view) {
        this.model = new QuizModel();
        this.view = view;
        data = model.getQuestionData();
        view.setBackgroundGr(model.getBackgroundGradient());
        view.setSubjectName(model.getSubjectName());
        testCount = data.size();
    }

    @Override
    public void onClickVariants(int index) {
        view.clearSelectedState();
        view.changeSelectedStateVariant(index, true);
        view.nextButtonEnabled(true);
    }

    @Override
    public void onClickNext() {
        checkCorrect(view.getSelectedVariantIndex());
        if (currentTest < testCount) {
            nextQuestion();
        } else {
            openResultActivity();
        }
        view.nextButtonEnabled(false);
    }

    @Override
    public void nextQuestion() {
        view.clearSelectedState();
        MyQuestionData temp = data.get(currentTest);
        variants.clear();
        variants.addAll(temp.getVariants());
        view.nextQuestion(temp.getQuestion(), variants, currentTest);
    }

    @Override
    public void onClickFinish() {
        int selectVariant = view.getSelectedVariantIndex();
        if (selectVariant != -1) {
            checkCorrect(selectVariant);
        }
        openResultActivity();
    }

    @Override
    public void openResultActivity() {
        model.setResult(correctTestCount, currentTest, testCount);
        view.openResultActivity();
    }

    private void checkCorrect(int selectVariantIndex) {
        MyQuestionData temp = data.get(currentTest++);
        String answer = temp.getAnswer();
        Log.d("TEST1", currentTest - 1 + " " + correctTestCount + " " + testCount);
        Log.d("TEST1", selectVariantIndex + " -> men tanlagan = " + variants.get(selectVariantIndex));
        Log.d("TEST1", selectVariantIndex + " -> to'g'ri = " + answer);

        if (answer.equals(variants.get(selectVariantIndex))) {
            correctTestCount++;
        }
    }
}
