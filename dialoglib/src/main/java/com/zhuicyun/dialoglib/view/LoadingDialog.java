package com.zhuicyun.dialoglib.view;


import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.TextView;

import com.zhuicyun.dialoglib.R;
import com.zhuicyun.dialoglib.base.BaseDialogFragment;

/**
 * Created by gwy on 2017/11/29.
 *
 * @author:zhuiyun
 */

public class LoadingDialog extends BaseDialogFragment {
    String hintText = "加载中...";
    int hintColor = Color.BLACK;
    LoadingView loadingView;
    int status;
    TextView hint;


    public LoadingDialog() {
    }

    public LoadingDialog(Builder builder) {
        if (builder.hintText != null) {
            this.hintText = builder.hintText;
        }
        if (builder.hintColor != 0) {
            this.hintColor = builder.hintColor;
        }
        this.status = builder.status;

    }


    @Override
    public LoadingDialog setStatus(int status) {
        this.status = status;
        return this;

    }

    @Override
    public int setLayId() {
        if (status == 0) {
            return R.layout.dialog_loading;
        } else if (status == 1) {
            return R.layout.loading_fail;
        } else {
            return R.layout.loading_done;
        }

    }

    @Override
    public int setBgId() {
        return R.drawable.bg_loading;
    }

    @Override
    public void initView(Dialog dialog) {
        loadingView = dialog.findViewById(R.id.loading);
        hint = dialog.findViewById(R.id.hint);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("status", status);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e("gao", "onViewStateRestored: ");
        status = savedInstanceState.getInt("status", 0);
    }


    @Override
    public int setStyle() {
        return R.style.dialog_loading;
    }

    @Override
    public void showDialog(FragmentManager manager) {
        super.showTDialog(manager, this.getClass());
    }


    @Override
    public void hideDialog() {
        loadingView.stop();
        this.onStop();
    }

    @Override
    public void setMsg() {
        if (loadingView != null) {
            loadingView.start();
        }
        if (hint != null) {
            try {
                hint.setText(hintText);
                hint.setTextColor(hintColor);
            } catch (Exception e) {
            }
        }

    }

    public static class Builder {
        String hintText;
        int hintColor;
        int status;

        public Builder setHintText(String hintText) {
            this.hintText = hintText;
            return this;
        }

        public Builder setHintColor(int hintColor) {
            this.hintColor = hintColor;
            return this;
        }

        public Builder setLoadingStatus(int status) {
            this.status = status;
            return this;
        }


        public LoadingDialog create() {
            return new LoadingDialog(this);
        }
    }

}
