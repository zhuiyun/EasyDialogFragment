package com.zhuicyun.dialoglib.view;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.widget.TextView;

import com.zhuicyun.dialoglib.R;
import com.zhuicyun.dialoglib.base.BaseBuilder;
import com.zhuicyun.dialoglib.base.BaseDialogFragment;

/**
 * Created by gwy on 2017/11/30.
 *
 * @author:zhuiyun
 */

public class LoadingFailDialog extends BaseDialogFragment {
    TextView hint;
    String hintText="加载失败";
    int hintColor= Color.BLACK;
    public LoadingFailDialog() {
    }



    public LoadingFailDialog(Builder builder) {
        if(builder.hintColor!=0){
            this.hintColor=builder.hintColor;
        }
        if(TextUtils.isEmpty(builder.hintText)){
            this.hintText=hintText;
        }

    }


    @Override
    public int setStyle() {
        return R.style.dialog_loading;
    }

    @Override
    public void showDialog(FragmentManager manager) {
        super.showTDialog(manager,this.getClass());
    }

    @Override
    public void hideDialog() {
        this.onStop();
    }

    @Override
    public BaseDialogFragment setStatus(int status) {
        return null;
    }

    @Override
    public int setLayId() {
        return R.layout.loading_fail;
    }

    @Override
    public int setBgId() {
        return R.drawable.bg_loading;
    }

    @Override
    public void initView(Dialog dialog) {
        hint=dialog.findViewById(R.id.hint);
    }

    @Override
    public void setMsg() {
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.bg_loading);
        if(hint!=null){
            try {
                hint.setText(hintText+"");
                hint.setTextColor(hintColor);
            }catch (Exception e){

            }
        }
    }

    public static class Builder extends BaseBuilder{
        String hintText="加载失败";
        int hintColor= Color.BLACK;

        public Builder setHintText(String hintText) {
            this.hintText = hintText;
            return this;
        }

        public Builder setHintColor(int hintColor) {
            this.hintColor = hintColor;
            return this;
        }

        @Override
        public LoadingFailDialog create() {
            return new LoadingFailDialog(this);
        }
    }

}
