package com.example.quizmvp.presentation.main_screen;

import com.example.quizmvp.data.model.MyCategory;
import com.example.quizmvp.data.model.SubjectData;

import java.util.List;

public interface MainContract {
    interface Model {
        void setSelectCategory(MyCategory category);
        List<SubjectData> getSubjectList();
    }

    interface View {
        void openQuizActivity();
        void setSubjectsList(List<SubjectData> dataList);
    }

    interface Present {
        void setSelectCategory(MyCategory category);
    }
}
