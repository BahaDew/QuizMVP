package com.example.quizmvp.presentation.main_screen;

import com.example.quizmvp.data.model.MyCategory;

public class MainPresenter implements MainContract.Present{
    private final MainContract.View view;
    private final MainContract.Model model;
    public MainPresenter(MainContract.View view) {
        this.view = view;
        model = new MainModel();
        view.setSubjectsList(model.getSubjectList());
    }
    @Override
    public void setSelectCategory(MyCategory category) {
        model.setSelectCategory(category);
        view.openQuizActivity();
    }
}
