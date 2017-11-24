package com.zhuicyun.dialoglib.base;

import android.support.v4.app.DialogFragment;
import android.view.WindowManager;

import com.zhuicyun.dialoglib.utils.DisplayHelper;

/**
 * Created by gwy on 2017/11/24.
 *
 * @author:zhuiyun
 */

public abstract class BaseDialogFragment extends DialogFragment {
    @Override
    public void onStart() {
        super.onStart();
        setMeasure();
        setMsg();
    }

   public  abstract void setMsg();

    /**
     * 设置弹窗大小
     */
    private void setMeasure() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = (int) (DisplayHelper.getScreenWidth(getActivity()) / 1.5);
        params.height = DisplayHelper.getScreenHeight(getActivity()) / 4;
        getDialog().getWindow().setAttributes(params);
//        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.bg_loading);
    }
}
