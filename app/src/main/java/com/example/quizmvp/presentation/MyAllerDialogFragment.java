package com.example.quizmvp.presentation;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.quizmvp.R;
import com.example.quizmvp.data.model.OnclickManageDialog;

import java.util.Objects;

public class MyAllerDialogFragment extends DialogFragment {
    private OnclickManageDialog onClickOk, onClickCancel;
    private String title = "", message = "", cancel = "Bekor qilish", ok = "Ha";
    private boolean isPositiveBtnCancel = true, isPositiveBtnOk = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_exit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvTitle = view.findViewById(R.id.title);
        tvTitle.setText(title);
        TextView tvMessage = view.findViewById(R.id.message);
        tvMessage.setText(message);
        TextView tvCancel = view.findViewById(R.id.btn_cancel);
        tvCancel.setText(cancel);
        tvCancel.setOnClickListener(v -> {
            if (onClickCancel != null) {
                onClickCancel.listener();
            } else {
                dismiss();
            }
        });
        TextView tvOk = view.findViewById(R.id.btn_ok);
        tvOk.setText(ok);
        tvOk.setOnClickListener(v -> {
            if (onClickOk != null) {
                onClickOk.listener();
            } else {
                dismiss();
            }
        });
        Objects.requireNonNull(getDialog()).setCancelable(false);
        if (isPositiveBtnCancel) {
            tvCancel.setTextColor(Color.parseColor("#61B6DC"));
            tvCancel.setBackgroundResource(R.drawable.bg_dialog_positive_btn);
        } else {
            tvCancel.setTextColor(Color.parseColor("#FF7F90"));
            tvCancel.setBackgroundResource(R.drawable.bg_dialog_negative_btn);
        }
        if (isPositiveBtnOk) {
            tvOk.setTextColor(Color.parseColor("#61B6DC"));
            tvOk.setBackgroundResource(R.drawable.bg_dialog_positive_btn);
        } else {
            tvOk.setTextColor(Color.parseColor("#FF7F90"));
            tvOk.setBackgroundResource(R.drawable.bg_dialog_negative_btn);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = Objects.requireNonNull(getDialog()).getWindow();
        if (window != null) {
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCancelBtnText(String cancel, OnclickManageDialog onClickCancel) {
        this.cancel = cancel;
        this.onClickCancel = onClickCancel;
    }

    public void setOkBtnText(String ok, OnclickManageDialog onClickOk) {
        this.ok = ok;
        this.onClickOk = onClickOk;
    }

    public void setPositiveStateBtnCancel(boolean positiveBtnCancel) {
        isPositiveBtnCancel = positiveBtnCancel;
    }

    public void setPositiveStateBtnOk(boolean positiveBtnOk) {
        isPositiveBtnOk = positiveBtnOk;
    }
}
