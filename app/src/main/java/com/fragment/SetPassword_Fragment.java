package com.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiao.activity.Login_Activity;
import com.example.xiao.sendmessagetest.R;

/**
 * Created by xiao on 2015/10/31.设置新密码
 */
public class SetPassword_Fragment extends Fragment {
    private EditText mFirst;//第一次输入的密码
    private EditText mSecond;//第二次输入的密码
    private Button mNext;//注册完毕进入登录界面

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setpassword, container, false);
        mFirst = (EditText) view.findViewById(R.id.et_first);
        mSecond = (EditText) view.findViewById(R.id.et_second);
        mFirst.requestFocus();
        mNext = (Button) view.findViewById(R.id.bn_password_next);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = mFirst.getText().toString().trim();
                String second = mSecond.getText().toString().trim();
                if (passwordIsRight(first, second)) {
                    Intent goLiginintent = new Intent(getActivity(), Login_Activity.class);
                    startActivity(goLiginintent);
                } else {
                    Toast.makeText(getActivity(), "两次密码不一致,请重新输入", Toast.LENGTH_SHORT).show();
                    mFirst.requestFocus();
                    mSecond.requestFocus();
                }

            }
        });
        return view;

    }

    public boolean passwordIsRight(String s1, String s2) {
        if (s1.equals(s2))//这里要用equals而不能用==
        {
            return true;
        } else {
            return false;
        }
    }
}
