package com.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiao.sendmessagetest.R;

/**
 * Created by xiao on 2015/11/20.
 * “我的”界面
 */
public class UserFragment extends Fragment {
    private LayoutInflater inflater;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.fragment_user,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

