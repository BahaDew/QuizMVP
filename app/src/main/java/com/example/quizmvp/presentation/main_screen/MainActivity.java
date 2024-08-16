package com.example.quizmvp.presentation.main_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quizmvp.R;
import com.example.quizmvp.data.model.SubjectData;
import com.example.quizmvp.presentation.main_screen.adapter.SubjectsAdapter;
import com.example.quizmvp.presentation.quiz_screen.QuizActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainContract.Present present;
    private RecyclerView recyclerView;
    private long time = System.currentTimeMillis();
    private final SubjectsAdapter adapter = new SubjectsAdapter();
    private boolean itemsClickable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        present = new MainPresenter(this);
        recyclerView = findViewById(R.id.rv);
        loading();
    }

    private void loading() {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnClickSubject(subjectData -> {
            if(!itemsClickable) return;
            if (System.currentTimeMillis() - time >= 500) {
                time = System.currentTimeMillis();
                present.setSelectCategory(subjectData.type);
            }
        });
    }

    @Override
    public void openQuizActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        itemsClickable = false;
    }

    @Override
    public void setSubjectsList(List<SubjectData> dataList) {
        adapter.setData(dataList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemsClickable = true;
    }
}