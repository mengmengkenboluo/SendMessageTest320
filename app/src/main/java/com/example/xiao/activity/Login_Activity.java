package com.example.xiao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiao.sendmessagetest.R;

/**
 * Created by xiao on 2015/10/31.
 */
public class Login_Activity extends Activity implements View.OnClickListener {
    private ImageView mBackMine;//返回我的界面
    private Button mGoRegist; //去注册界面
    private EditText mLoginPhone; //登录帐号
    private EditText mLoginPassword;//输入登录密码
    private Button mLogin;//登录按钮
    private TextView mFind;//找回密码
    private TextView mQuick;//快速登录

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    //控件初始化
    private void init() {
        mBackMine = (ImageView) findViewById(R.id.iv_back_mine);
        mGoRegist = (Button) findViewById(R.id.bn_regist);
        mLoginPhone = (EditText) findViewById(R.id.et_login);
        mLoginPassword = (EditText) findViewById(R.id.et_login_password);
        mLogin = (Button) findViewById(R.id.bn_login);
        mFind = (TextView) findViewById(R.id.tv_find_password);
        mQuick = (TextView) findViewById(R.id.tv_quick_login);
        mBackMine.setOnClickListener(this);
        mGoRegist.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mFind.setOnClickListener(this);
        mQuick.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_mine:
                break;
            case R.id.bn_regist:
                break;
            case R.id.tv_find_password:
                break;
            case R.id.tv_quick_login:
                break;
            case R.id.bn_login:
                break;
        }

    }
}
