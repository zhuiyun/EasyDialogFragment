package com.zhuicyun.easydialogfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zhuicyun.dialoglib.view.TipsAndTitleHaveSureButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      LoadingDialog baseDialogFragment = new LoadingDialog.Builder().create();
//       baseDialogFragment.showDialog(getSupportFragmentManager());
//
        final TipsAndTitleHaveSureButton sureButton=new TipsAndTitleHaveSureButton.Builder().setHintTitle("警告").setRemoveTitle(true).create();
        sureButton.setSureClickListener(new TipsAndTitleHaveSureButton.SureClickListener() {
            @Override
            public void sure() {
                Log.e("gao", "sure: ");
                sureButton.hideDialog();
            }
        });
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              sureButton.showDialog(getSupportFragmentManager());
            }
        });
//        new TipsDialog.Builder().setColor(Color.BLACK).setHintText("网络错误").create().showDialog(getSupportFragmentManager());
    }
}
