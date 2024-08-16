package com.example.quizmvp.presentation.result_screen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.view.WindowInsetsControllerCompat;

import com.example.quizmvp.R;
import com.example.quizmvp.data.model.MyResultData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SuppressLint("MissingInflatedId")
public class ResultActivity extends AppCompatActivity implements ResultContract.View {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ResultContract.Presenter presenter = new ResultPresenter(this);
        presenter.loadResult();
        firstLoad();
    }

    private void firstLoad() {
        findViewById(R.id.btn_close).setOnClickListener(v -> {
            finish();
        });
        findViewById(R.id.btn_share).setOnClickListener(v -> {
            saveAndShareScreenshot(getWindow().getDecorView());
        });
        WindowInsetsControllerCompat wic = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        wic.setAppearanceLightStatusBars(false);
    }

    @Override
    public void setBackgroundGradient(int bgResId) {
        findViewById(R.id.root).setBackgroundResource(bgResId);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setResultData(MyResultData resultData, String subjectName) {
        int percentage = resultData.getCorrectAnswerCount() * 100 / resultData.getTestCount();
        TextView foiz = findViewById(R.id.percentage);
        foiz.setText(percentage + "%");
        if (percentage < 50) {
            foiz.setTextColor(Color.parseColor("#E5802F"));
            foiz.setShadowLayer(4, 5, 5, Color.parseColor("#E5802F"));
            TextView natija = findViewById(R.id.natija);
            natija.setText("Yaxshi natija !");
            ImageView cub = findViewById(R.id.cub);
            cub.setImageResource(R.drawable.logo_quiz);
            cub.setBackground(null);
        }
        TextView result = findViewById(R.id.result);
        SpannableStringBuilder ssb = getSpannableStringBuilder(resultData, subjectName);
        // Siz Ingiliz tilining 10 ta testidan 9 tasiga javob berdingiz va ulardan 9 tasi to'g'ri deb topildi!
        result.setText(ssb);
    }

    @NonNull
    private static SpannableStringBuilder getSpannableStringBuilder(MyResultData resultData, String subjectName) {
        String name = "Siz " + subjectName + " quizining ";
        String countStr = resultData.getTestCount() + " ta";
        String correctStr = resultData.getCorrectAnswerCount() + " tasiga to'g'ri";
        String jum = name + countStr + " testidan ";
        SpannableStringBuilder ssb = new SpannableStringBuilder(
                jum + correctStr + " javob berdingiz !"
        );
        ssb.setSpan(
                new ForegroundColorSpan(Color.parseColor("#1B6BA9")),
                name.length(),
                name.length() + countStr.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        ssb.setSpan(
                new StyleSpan(Typeface.BOLD),
                name.length(),
                name.length() + countStr.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        ssb.setSpan(
                new ForegroundColorSpan(Color.parseColor("#2EBC6C")),
                jum.length(),
                jum.length() + correctStr.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        ssb.setSpan(
                new StyleSpan(Typeface.BOLD),
                jum.length(),
                jum.length() + correctStr.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        return ssb;
    }

    public Bitmap getScreenshot(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap screenshot = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return screenshot;
    }

    // Joriy oynani screenshotni xotiraga saqlash va yuborish
    public void saveAndShareScreenshot(View view) {
        Bitmap screenshot = getScreenshot(view);

        // Xotiraga saqlash
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_mm_ss", Locale.ROOT);
        String fileName = dateFormat.format(new Date(System.currentTimeMillis())) + ".png";
        File file = new File(getExternalFilesDir(null), fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            screenshot.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            Log.d("TEST1", "saveAndShareScreenshot: error");
        }

        // Screenshotni yuborish
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/png");
        intent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", file));
        startActivity(Intent.createChooser(intent, "Screenshotni yuborish"));
    }
}
