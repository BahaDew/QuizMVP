package com.example.quizmvp.presentation.result_screen;

import com.example.quizmvp.data.model.MyResultData;
import com.example.quizmvp.domain.AppController;

public class ResultModel implements ResultContract.Model {
    private final AppController appController = AppController.getInstance();

    @Override
    public MyResultData getResultData() {
        return appController.getResultData();
    }

    @Override
    public int getBackgroundGradient() {
        return appController.getBackgroundGradient();
    }

    @Override
    public String getSubjectName() {
        return appController.getSubjectName();
    }
}
