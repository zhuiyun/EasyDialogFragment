package com.zhuicyun.dialoglib.view;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.zhuicyun.dialoglib.R;
import com.zhuicyun.dialoglib.base.BaseBuilder;
import com.zhuicyun.dialoglib.base.BaseDialogFragment;

/**
 * Created by gwy on 2017/12/1.
 *
 * @author:zhuiyun
 */

public class TipsAndTitleHaveSureButton extends BaseDialogFragment {
    String hintTitle = "温馨提示", hintContent = "别乱动", hintBtn = "确认";
    int titleColor = Color.BLACK, contentColor = Color.BLUE, btnColor = Color.WHITE;
    int titleBg = Color.CYAN, contentBg = Color.GREEN, btnBg = Color.RED;
    boolean isRemoveTitle;
    TextView title, content, btn;
    public interface  SureClickListener{
        void sure();
    }

    SureClickListener sureClickListener;
    public void setSureClickListener(SureClickListener sureClickListener){
        this.sureClickListener=sureClickListener;
    }



    public TipsAndTitleHaveSureButton(Builder builder) {
        this.hintTitle = builder.hintTitle;
        this.hintContent = builder.hintContent;
        this.titleColor = builder.titleColor;
        this.contentColor = builder.contentColor;
        this.titleBg = builder.titleBg;
        this.contentBg = builder.contentBg;
        this.hintBtn = builder.hintBtn;
        this.btnColor = builder.btnColor;
        this.btnBg = builder.btnBg;
        this.isRemoveTitle=builder.isRemoveTitle;

    }

    public TipsAndTitleHaveSureButton() {
    }

    @Override
    public int setStyle() {
        return R.style.dialog_fragment;
    }

    @Override
    public void showDialog(FragmentManager manager) {
        super.showTDialog(manager, this.getClass());
    }

    @Override
    public void hideDialog() {
        getDialog().dismiss();
    }

    @Override
    public BaseDialogFragment setStatus(int status) {
        return null;
    }

    @Override
    public int setLayId() {
        return R.layout.dialog_tips_and_button;
    }

    @Override
    public int setBgId() {
        return R.drawable.bg_dialog_common;
    }

    @Override
    public void initView(Dialog dialog) {
        title = dialog.findViewById(R.id.title);
        content = dialog.findViewById(R.id.content);
        btn = dialog.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sureClickListener.sure();
            }
        });
    }

    @Override
    public void setMsg() {
        title.setText(TextUtils.isEmpty(hintTitle) ? "温馨提示" : hintTitle);
        title.setTextColor(titleColor == 0 ? Color.BLACK : titleColor);
        title.setBackgroundColor(titleBg == 0 ? Color.YELLOW : titleBg);

        content.setText(TextUtils.isEmpty(hintContent) ? "温馨提示" : hintContent);
        content.setTextColor(contentColor == 0 ? Color.BLACK : contentColor);
        content.setBackgroundColor(contentBg == 0 ? Color.BLUE : contentBg);

        btn.setText(TextUtils.isEmpty(hintBtn) ? "确认" : hintBtn);
        btn.setTextColor(btnColor == 0 ? Color.WHITE : btnColor);
        btn.setBackgroundColor(btnBg == 0 ? Color.RED : btnBg);
        if (isRemoveTitle) {
            title.setVisibility(View.GONE);
        }
    }

    public static class Builder extends BaseBuilder {
        String hintTitle, hintContent, hintBtn;
        int titleColor, contentColor, btnColor;
        int titleBg, contentBg, btnBg;
        boolean isRemoveTitle;

        public Builder setRemoveTitle(boolean removeTitle) {
            isRemoveTitle = removeTitle;
            return this;
        }

        public Builder setHintBtn(String hintBtn) {
            this.hintBtn = hintBtn;
            return this;
        }

        public Builder setBtnColor(int btnColor) {
            this.btnColor = btnColor;
            return this;
        }

        public Builder setBtnBg(int btnBg) {
            this.btnBg = btnBg;
            return this;
        }

        public Builder setHintTitle(String hintTitle) {
            this.hintTitle = hintTitle;
            return this;
        }

        public Builder setHintContent(String hintContent) {
            this.hintContent = hintContent;
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder setContentColor(int contentColor) {
            this.contentColor = contentColor;
            return this;
        }

        public Builder setTitleBg(int titleBg) {
            this.titleBg = titleBg;
            return this;
        }

        public Builder setContentBg(int contentBg) {
            this.contentBg = contentBg;
            return this;
        }

        @Override
        public TipsAndTitleHaveSureButton create() {
            return new TipsAndTitleHaveSureButton(this);
        }
    }

}
