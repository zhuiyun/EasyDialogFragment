package com.zhuicyun.dialoglib.view;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.zhuicyun.dialoglib.R;
import com.zhuicyun.dialoglib.base.BaseBuilder;
import com.zhuicyun.dialoglib.base.BaseDialogFragment;

/**
 * Created by gwy on 2017/11/30.
 *
 * @author:zhuiyun
 */

public class TipsDialog extends BaseDialogFragment {
    TextView hint;
    String hintText="网络错误";
    int hintColor= Color.BLACK;

    public TipsDialog(Builder builder) {
        if(TextUtils.isEmpty(builder.hintText)){
            this.hintText=builder.hintText;
        }
        if(builder.color!=0){
            this.hintColor=builder.color;
        }
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

    }

    @Override
    public BaseDialogFragment setStatus(int status) {
        return null;
    }

    @Override
    public int setLayId() {
        return R.layout.dialog_tips;
    }

    @Override
    public int setBgId() {
        return R.drawable.bg_dialog_common;
    }

    @Override
    public void initView(Dialog dialog) {
        hint=dialog.findViewById(R.id.hint);

    }

    @Override
    public void setMsg() {
        Log.e("gao", "setMsg: "+hint);
        if (hint != null) {
            hint.setText(hintText);
            hint.setTextColor(hintColor);
        }


    }

    public static class Builder extends BaseBuilder{
        String hintText;
        int color;

        public Builder setHintText(String hintText) {
            this.hintText = hintText;
            return this;
        }

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }

        @Override
        public TipsDialog create() {
            return new TipsDialog(this);
        }
    }

}
