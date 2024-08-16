package com.example.quizmvp.presentation.result_screen;


import com.example.quizmvp.data.model.MyResultData;

public class ResultPresenter implements ResultContract.Presenter {
    private ResultContract.Model model;
    private final ResultContract.View view;
    private final MyResultData data;

    public ResultPresenter(ResultContract.View view) {
        this.view = view;
        this.model = new ResultModel();
        data = model.getResultData();
    }

    @Override
    public void loadResult() {
        view.setBackgroundGradient(model.getBackgroundGradient());
        view.setResultData(data,model.getSubjectName());
    }
}
