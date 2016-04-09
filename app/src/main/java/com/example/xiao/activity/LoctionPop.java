package com.example.xiao.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by xiao on 2015/11/15.弹窗选择地点
 */
public class LoctionPop extends PopupWindow {
    private TextView mArae;//显示城市区
    private View mPopView;
    private LayoutInflater inflater;
    //创建构造方法 传入Context,和Item被点击
    public LoctionPop(Context context,View.OnClickListener itemsOnClick){
        super(context);
        inflater =LayoutInflater.from(context);

    }

}
