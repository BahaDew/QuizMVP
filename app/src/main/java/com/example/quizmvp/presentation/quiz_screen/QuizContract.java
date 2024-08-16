package com.example.quizmvp.presentation.quiz_screen;

import com.example.quizmvp.data.model.MyQuestionData;

import java.util.List;

public interface QuizContract {
    interface Model {
        List<MyQuestionData> getQuestionData();
        int getBackgroundGradient();

        String getSubjectName();

        void setResult(int correctTestCount, int currentTest, int testCount);
    }

    interface View {

        void nextQuestion(String question, List<String> variants, int currentIndex);

        void openResultActivity();

        void nextButtonEnabled(boolean enabled);

        void setBackgroundGr(int resId);

        void setSubjectName(String name);

        int getSelectedVariantIndex();

        void changeSelectedStateVariant(int index, boolean state);

        void clearSelectedState();
    }

    interface Presenter {
        void onClickVariants(int index);

        void onClickNext();

        void onClickFinish();

        public void nextQuestion();

        public void openResultActivity();
    }
}
