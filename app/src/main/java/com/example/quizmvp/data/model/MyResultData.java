package com.example.quizmvp.data.model;

public class MyResultData {
    private final int correctAnswerCount;
    private final int currentTest;
    private final int testCount;

    public MyResultData(int correctAnswerCount, int currentTest, int testCount) {
        this.correctAnswerCount = correctAnswerCount;
        this.currentTest = currentTest;
        this.testCount = testCount;
    }

    public int getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    public int getCurrentTest() {
        return currentTest;
    }

    public int getTestCount() {
        return testCount;
    }
}
