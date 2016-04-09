package com.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiao.sendmessagetest.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiao on 2015/11/1.填写手机号
 */
public class PhoneNum_Fragment extends Fragment {
    private Button mGetVar; //获取验证码按钮
    private View view;
    private GetVar_Fragment getVar_fragment;
    private PhoneNum_Fragment phoneNum_fragment;
    private TextView mPhone;
    private TextView mCode;
    private EditText mEditPhone;//输入手机号
    private CheckBox mCheck;//是否同意美团协议

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_phonenum, container, false);
        phoneNum_fragment = new PhoneNum_Fragment();
        getVar_fragment = new GetVar_Fragment();
        mCode = (TextView) getActivity().findViewById(R.id.text_code);
        mPhone = (TextView) getActivity().findViewById(R.id.text_phone);
        mEditPhone = (EditText) view.findViewById(R.id.edit_phone);
        mCheck = (CheckBox) view.findViewById(R.id.checkbox);
        mGetVar = (Button) view.findViewById(R.id.bn_get_var);
        mGetVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                if (registNum() && mCheck.isChecked()) { //如果手机号正确
                    switchContent(phoneNum_fragment, getVar_fragment);
                    mPhone.setTextColor(getResources().getColor(R.color.gray));
                    mCode.setTextColor(getResources().getColor(R.color.meituan));
                } else { //如果手机号不正确或未同意美团协议
                    Toast.makeText(getActivity(), "您输入手机号有误,或您没有同意美团协议", Toast.LENGTH_SHORT).show();
                    mEditPhone.requestFocus(); //一定要让EditText重新获得焦点，否则出错
                }
            }
        });
        return view;
    }

    public boolean registNum() {

    String num = mEditPhone.getText().toString().trim();
    if (num == "" || !checkPhoneNum(num)) {
        return false;
    } else
            return true;
}
    public void switchContent(Fragment mContent, Fragment to) {
        if (mContent != to) {  //当前fragment与待添加的不相同
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            if (!to.isAdded()) { //如果to没有被添加
                mContent = getFragmentManager().findFragmentByTag("phoneNum");
                transaction.hide(mContent).add(R.id.fragment_container, to, "GetVar").commit();
            } else {
                mContent = getFragmentManager().findFragmentByTag("phoneNum");
                transaction.hide(mContent).show(to).commit();

            }
        }
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }

    //判断手机号的正则表达式
    public boolean checkPhoneNum(String Pnum) {
        String telReg = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
        Pattern p = Pattern.compile(telReg);
        Matcher m = p.matcher(Pnum);
        return m.find();
    }
}

