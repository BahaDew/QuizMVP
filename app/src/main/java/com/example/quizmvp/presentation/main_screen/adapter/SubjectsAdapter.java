package com.example.quizmvp.presentation.main_screen.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizmvp.R;
import com.example.quizmvp.data.model.OnClickSubject;
import com.example.quizmvp.data.model.SubjectData;

import java.util.ArrayList;
import java.util.List;

public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.SubjectsHolder> {

    private final List<SubjectData> data = new ArrayList<>();
    private OnClickSubject onClickSubject;

    @NonNull
    @Override
    public SubjectsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubjectsHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_subject, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectsHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SubjectsHolder extends RecyclerView.ViewHolder {
        private final LinearLayout container;
        private final ImageView image;
        private final TextView name, countQuiz;
        private View root;

        public SubjectsHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            image = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            countQuiz = itemView.findViewById(R.id.count_quiz);
            root = itemView;
            container.setOnClickListener(v -> {
                onClickSubject.listener(data.get(getAdapterPosition()));
            });
        }

        @SuppressLint("SetTextI18n")
        public void bind(int position) {
            SubjectData subjectData = data.get(position);
            image.setImageResource(subjectData.imgId);
            container.setBackgroundResource(subjectData.bgResId);
            name.setText(subjectData.name);
            countQuiz.setText(subjectData.quizCount + " ta quiz");
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<SubjectData> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setOnClickSubject(OnClickSubject onClickSubject) {
        this.onClickSubject = onClickSubject;
    }
}
