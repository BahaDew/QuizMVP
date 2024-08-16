package com.example.quizmvp.presentation.result_screen;

import android.widget.TextView;

import com.example.quizmvp.data.model.MyResultData;

public interface ResultContract {
    interface Model {
        MyResultData getResultData();

        int getBackgroundGradient();

        String getSubjectName();
    }
    interface View {
        void setBackgroundGradient(int bgResId);
        void setResultData(MyResultData resultData, String subjectName);
    }
    interface Presenter {
        void loadResult();
    }
}
