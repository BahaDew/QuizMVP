package com.example.quizmvp.presentation.quiz_screen;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowInsetsControllerCompat;

import com.example.quizmvp.R;
import com.example.quizmvp.data.model.MyPair;
import com.example.quizmvp.presentation.MyAllerDialogFragment;
import com.example.quizmvp.presentation.result_screen.ResultActivity;

import java.util.ArrayList;
import java.util.List;


public class QuizActivity extends AppCompatActivity implements QuizContract.View {
    private QuizContract.Presenter presenter;
    private int oldSelectedIndex = -1;
    private TextView questionText;
    private TextView btnNext;
    private ConstraintLayout root;
    private long time = 0;
    private List<MyPair<LinearLayout, TextView, TextView>> variants;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        root = findViewById(R.id.root);
        presenter = new QuizPresenter(this);
        loadFirst();
    }

    public void loadFirst() {
        variants = new ArrayList<>();
        LinearLayout variantsContainer = findViewById(R.id.variants_container);
        for (int i = 0; i < variantsContainer.getChildCount(); i++) {
            LinearLayout first = (LinearLayout) variantsContainer.getChildAt(i);
            TextView second = (TextView) first.getChildAt(0);
            TextView three = (TextView) first.getChildAt(1);
            variants.add(new MyPair<>(first, second, three));
            int index = i;
            first.setOnClickListener(v -> {
                if (System.currentTimeMillis() - time >= 200) {
                    time = System.currentTimeMillis();
                    presenter.onClickVariants(index);
                }
            });
        }
        questionText = findViewById(R.id.question_text);
        TextView btnFinish = findViewById(R.id.btn_finish);
        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(v -> presenter.onClickNext());
        btnFinish.setOnClickListener(v -> openFinishDialog());
        findViewById(R.id.btn_close).setOnClickListener(v -> {
            if (System.currentTimeMillis() - time >= 200) {
                time = System.currentTimeMillis();
                openExitDialog();
            }
        });
        presenter.nextQuestion();
        WindowInsetsControllerCompat wic = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        wic.setAppearanceLightStatusBars(false);
    }

    @Override
    public void nextQuestion(String question, List<String> variants, int currentIndex) {
        SpannableString spannableString = new SpannableString(currentIndex + 1 + ". " + question);
        spannableString.setSpan(
                new StyleSpan(Typeface.BOLD),
                0,
                2,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        questionText.setText(spannableString);
        for (int i = 0; i < this.variants.size(); i++) {
            this.variants.get(i).three.setText(variants.get(i));
        }
        oldSelectedIndex = -1;
    }

    @Override
    public void openResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void nextButtonEnabled(boolean enabled) {
        btnNext.setEnabled(enabled);
        if (enabled) {
            btnNext.setElevation(25);
        } else {
            btnNext.setElevation(0);
        }
    }

    @Override
    public void setBackgroundGr(int resId) {
        root.setBackgroundResource(resId);
    }

    @Override
    public void setSubjectName(String name) {
        TextView subjectName = findViewById(R.id.name);
        subjectName.setText(name);
    }

    @Override
    public int getSelectedVariantIndex() {
        return oldSelectedIndex;
    }

    @Override
    public void changeSelectedStateVariant(int index, boolean state) {
        if (index < 0 || index >= variants.size()) return;
        oldSelectedIndex = index;
        variants.get(index).first.setSelected(state);
        variants.get(index).second.setSelected(state);
        variants.get(index).three.setSelected(state);
    }

    @Override
    public void clearSelectedState() {
        if (oldSelectedIndex < 0 || oldSelectedIndex >= variants.size()) return;
        variants.get(oldSelectedIndex).first.setSelected(false);
        variants.get(oldSelectedIndex).second.setSelected(false);
        variants.get(oldSelectedIndex).three.setSelected(false);
    }

    private void openExitDialog() {
        MyAllerDialogFragment exitDialogFr = new MyAllerDialogFragment();
        exitDialogFr.setOkBtnText("Ha", () -> {
            if (System.currentTimeMillis() - time >= 500) {
                time = System.currentTimeMillis();
                finish();
            }
        });
        exitDialogFr.setCancelBtnText("Bekor qilish", null);
        exitDialogFr.setTitle("Chiqish");
        exitDialogFr.setMessage("Haqiqat dan ham quizdan chiqishni xohlaysizmi?");
        exitDialogFr.show(getSupportFragmentManager(), "exit");
    }

    private void openFinishDialog() {
        MyAllerDialogFragment finishDialogFr = new MyAllerDialogFragment();
        finishDialogFr.setOkBtnText("Ha", this::finish);
        finishDialogFr.setCancelBtnText("Bekor qilish", null);
        finishDialogFr.setTitle("Tugatish");
        finishDialogFr.setMessage("Haqiqat dan ham quizni tugatishni xohlaysizmi?");
        finishDialogFr.setOkBtnText("Ha", () -> {
            if (System.currentTimeMillis() - time >= 500) {
                time = System.currentTimeMillis();
                presenter.onClickFinish();
            }
        });
        finishDialogFr.show(getSupportFragmentManager(), "exit");
    }
}
