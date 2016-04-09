package com.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiao.sendmessagetest.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiao on 2015/10/31.获取验证码
 * 验证码应该通过后台来验证。这里先用正则表达式来代替
 */
public class GetVar_Fragment extends Fragment {
    private Button mCode;
    private GetVar_Fragment getVar_fragment;
    private SetPassword_Fragment setPassword_fragment;
    private TextView mTextCode;
    private TextView mTextPassword;
    private EditText mMessageNum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_getvar, container, false);
        mTextCode = (TextView) getActivity().findViewById(R.id.text_code);
        mTextPassword = (TextView) getActivity().findViewById(R.id.text_password);
        mMessageNum = (EditText) view.findViewById(R.id.et_messagenum);
        mMessageNum.requestFocus();
        mCode = (Button) view.findViewById(R.id.bn_submit_code);
        mCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVar_fragment = new GetVar_Fragment();
                setPassword_fragment = new SetPassword_Fragment();
                if (codeisRight()) {
                    switchContent(getVar_fragment, setPassword_fragment);
                    mTextCode.setTextColor(getResources().getColor(R.color.gray));
                    mTextPassword.setTextColor(getResources().getColor(R.color.meituan));
                } else {
                    Toast.makeText(getActivity(), "验证码有误", Toast.LENGTH_SHORT).show();
                    mMessageNum.requestFocus();
                }
            }
        });
        return view;
    }

    public void switchContent(Fragment mContent, Fragment to) {
        if (mContent != to) {  //当前fragment与待添加的不相同
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            if (!to.isAdded()) { //如果to没有被添加
                mContent = getFragmentManager().findFragmentByTag("GetVar");
                transaction.hide(mContent).add(R.id.fragment_container, to, "SetPassword").commit();
            } else {
                mContent = getFragmentManager().findFragmentByTag("GetVar");
                transaction.hide(mContent).show(to).commit();

            }
        }
    }

    public boolean codeisRight() {
        String c = mMessageNum.getText().toString().trim();
        if (c == "" || !checkCode(c)) {
            return false;
        } else {
            return true;
        }

    }

    //判断验证码的正则表达式
    public boolean checkCode(String code) {
        String myCode = "^[0-9][0-9][0-9][0-9]$";
        Pattern pattern = Pattern.compile(myCode);//将正则表达式编译到这个模式中
        Matcher matcher = pattern.matcher(code);//创建 匹配给定输入与此模式  的匹配器。
        return matcher.find();//返回匹配的结果  //尝试查找与该模式匹配的输入序列的下一个子序列

    }
}
