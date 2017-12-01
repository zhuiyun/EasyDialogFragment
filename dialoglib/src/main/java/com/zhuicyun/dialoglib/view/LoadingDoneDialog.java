package com.zhuicyun.dialoglib.view;

import android.app.Dialog;
import android.support.v4.app.FragmentManager;

import com.zhuicyun.dialoglib.R;
import com.zhuicyun.dialoglib.base.BaseBuilder;
import com.zhuicyun.dialoglib.base.BaseDialogFragment;

/**
 * Created by gwy on 2017/11/30.
 *
 * @author:zhuiyun
 */

public class LoadingDoneDialog extends BaseDialogFragment {
    public LoadingDoneDialog() {
    }


    public LoadingDoneDialog(Builder builder) {

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
        return R.layout.loading_done;
    }

    @Override
    public int setBgId() {
        return R.drawable.bg_loading;
    }

    @Override
    public void initView(Dialog dialog) {

    }

    @Override
    public void setMsg() {
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.bg_loading);
    }

    public static class Builder extends BaseBuilder{
        @Override
        public BaseDialogFragment create() {
            return new LoadingDoneDialog(this);
        }
    }

}
