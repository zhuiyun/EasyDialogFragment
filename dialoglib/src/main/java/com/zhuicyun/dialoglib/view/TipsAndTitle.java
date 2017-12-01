package com.zhuicyun.dialoglib.view;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.widget.TextView;

import com.zhuicyun.dialoglib.R;
import com.zhuicyun.dialoglib.base.BaseBuilder;
import com.zhuicyun.dialoglib.base.BaseDialogFragment;

/**
 * Created by gwy on 2017/12/1.
 *
 * @author:zhuiyun
 */

public class TipsAndTitle extends BaseDialogFragment {
    String hintTitle="温馨提示",hintContent="别乱动";
    int titleColor= Color.BLACK,contentColor=Color.BLUE;
    int titleBg=Color.CYAN,contentBg=Color.GREEN;

    TextView title,content;
    public TipsAndTitle(Builder builder) {
        this.hintTitle=builder.hintTitle;
        this.hintContent=builder.hintContent;
        this.titleColor=builder.titleColor;
        this.contentColor=builder.contentColor;
        this.titleBg=builder.titleBg;
        this.contentBg=builder.contentBg;
    }

    public TipsAndTitle() {
    }

    @Override
    public int setStyle() {
        return R.style.dialog_fragment;
    }

    @Override
    public void showDialog(FragmentManager manager) {
        super.showTDialog(manager,this.getClass());
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
        return R.layout.dialog_tips_and_title;
    }

    @Override
    public int setBgId() {
        return R.drawable.bg_dialog_common;
    }

    @Override
    public void initView(Dialog dialog) {
        title=dialog.findViewById(R.id.title);
        content=dialog.findViewById(R.id.content);
    }

    @Override
    public void setMsg() {
        title.setText(TextUtils.isEmpty(hintTitle)?"温馨提示":hintTitle);
        title.setTextColor(titleColor==0?Color.BLACK:titleColor);
        title.setBackgroundColor(titleBg==0?Color.YELLOW:titleBg);

        content.setText(TextUtils.isEmpty(hintContent)?"温馨提示":hintContent);
        content.setTextColor(contentColor==0?Color.BLACK:contentColor);
        content.setBackgroundColor(contentBg==0?Color.BLUE:contentBg);
    }

    public static class Builder extends BaseBuilder{
        String hintTitle,hintContent;
        int titleColor,contentColor;
        int titleBg,contentBg;

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
        public TipsAndTitle create() {
            return new TipsAndTitle(this);
        }
    }

}
