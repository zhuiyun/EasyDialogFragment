package com.zhuicyun.dialoglib.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
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
        setMsg();
        setMeasure();
        getDialog().getWindow().setBackgroundDrawableResource(setBgId());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog=new Dialog(getActivity(), setStyle());
        dialog.setContentView(setLayId());
        initView(dialog);
        return dialog;
    }

    public abstract int setStyle();

    /**
     * 显示弹窗
     * @param manager
     */
    public   abstract void showDialog(FragmentManager manager);

   public void showTDialog(FragmentManager manager,Class cl){
       this.show(manager,cl.toString());
   }



    /**
     * 隐藏弹窗
     */
    public abstract void hideDialog();

    /**
     * 弹窗状态
     * @param status
     * @return
     */
    public abstract BaseDialogFragment setStatus(int status);

    /**
     * 弹窗布局
     * @return
     */
    public abstract int setLayId();

    /**
     * 弹窗背景
     * @return
     */
    public abstract int setBgId();

    /**
     * 初始化
     * @param dialog
     */
    public abstract void initView(Dialog dialog);

    public BaseDialogFragment() {
    }

    /**
     * 弹窗显示后的设置数据
     */
    public  abstract void setMsg();

    /**
     * 设置弹窗大小
     */
    private void setMeasure() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = (int) (DisplayHelper.getScreenWidth(getActivity()) / 1.5);
        params.height = DisplayHelper.getScreenHeight(getActivity()) / 4;
        params.dimAmount=0.0f;
        getDialog().getWindow().setAttributes(params);

    }
}
