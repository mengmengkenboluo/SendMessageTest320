package com.example.xiao.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.xiao.sendmessagetest.R;
import com.fragment.PhoneNum_Fragment;

/**
 * 注册界面
 */

public class Regist_Activity extends Activity {
    private TextView mPhone; //变色TextView
    private FrameLayout frameLayout; //填充Fragment的布局
    private ImageButton imageBackButton;//退出界面Button

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();

    }

    /*
    * 初始化控件*/
    private void init() {
        frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        PhoneNum_Fragment phoneNum_fragment = new PhoneNum_Fragment();
        getFragmentManager().beginTransaction().add(R.id.fragment_container, phoneNum_fragment, "phoneNum").commit();
        mPhone = (TextView) findViewById(R.id.text_phone);
        mPhone.setTextColor(getResources().getColor(R.color.meituan));
        imageBackButton = (ImageButton) findViewById(R.id.id_back);
        imageBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Regist_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
