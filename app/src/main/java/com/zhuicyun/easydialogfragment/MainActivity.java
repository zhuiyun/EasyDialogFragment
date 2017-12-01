package com.zhuicyun.easydialogfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhuicyun.dialoglib.view.TipsAndTitleHaveSureButton;
import com.zhuicyun.dialoglib.view.TipsDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      LoadingDialog baseDialogFragment = new LoadingDialog.Builder().create();
//       baseDialogFragment.showDialog(getSupportFragmentManager());
//
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new TipsAndTitleHaveSureButton.Builder().setHintTitle("警告").create().showDialog(getSupportFragmentManager());
            }
        });
        new TipsDialog.Builder().setColor(Color.BLACK).setHintText("网络错误").create().showDialog(getSupportFragmentManager());
    }
}
