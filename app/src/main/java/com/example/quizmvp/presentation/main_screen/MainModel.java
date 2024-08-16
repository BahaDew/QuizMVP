package com.example.quizmvp.presentation.main_screen;

import com.example.quizmvp.data.model.MyCategory;
import com.example.quizmvp.data.model.SubjectData;
import com.example.quizmvp.domain.AppController;

import java.util.List;

public class MainModel implements MainContract.Model{

    private final AppController appController = AppController.getInstance();
    @Override
    public void setSelectCategory(MyCategory category) {
        appController.setSelectCategory(category);
    }

    @Override
    public List<SubjectData> getSubjectList() {
        return appController.getSubjectDataList();
    }
}
