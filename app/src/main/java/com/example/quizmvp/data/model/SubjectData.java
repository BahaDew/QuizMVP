package com.example.quizmvp.data.model;

public class SubjectData {
    public String name;
    public int bgResId, imgId, quizCount;
    public MyCategory type;

    public SubjectData(String name, int bgResId, int imgId, MyCategory type, int quizCount) {
        this.name = name;
        this.bgResId = bgResId;
        this.imgId = imgId;
        this.type = type;
        this.quizCount = quizCount;
    }
}
