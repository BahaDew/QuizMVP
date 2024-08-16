package com.example.quizmvp.presentation.quiz_screen;

import com.example.quizmvp.data.model.MyQuestionData;
import com.example.quizmvp.domain.AppController;

import java.util.List;

public class QuizModel implements QuizContract.Model {

    private final AppController appController;

    public QuizModel() {
        appController = AppController.getInstance();
    }

    @Override
    public List<MyQuestionData> getQuestionData() {
        return appController.getQuestionData();
    }

    @Override
    public int getBackgroundGradient() {
        return appController.getBackgroundGradient();
    }

    @Override
    public String getSubjectName() {
        return appController.getSubjectName();
    }

    @Override
    public void setResult(int correctTestCount, int currentTest, int testCount) {
        appController.setResult(correctTestCount, currentTest, testCount);
    }

}
