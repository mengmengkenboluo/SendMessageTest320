package com.xiao.myself;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.xiao.sendmessagetest.R;

/**
 * Created by xiao on 2015/11/28.
 * 头部View
 */
public class MyHeaderView extends LinearLayout {
    // 下拉状态
    public static final int STATUS_NORMAL = 0;//处于原位状态
    public static final int STATUS_PULL = 1; //下拉状态
    public static final int STATUS_REFRESHING = 2;//刷新状态
    private LinearLayout mContainer;
    //当前状态
    private int currentStatus=STATUS_NORMAL;
    //下拉动画
    private AnimationDrawable mAnimationDrawable_pull;
    //刷新动画
    private AnimationDrawable mAnimationDrawable_refreshing;
    private ImageView mAnimation;
    public MyHeaderView(Context context) {
        super(context);
        initview();
    }
    private void initview() {
        //设置宽和高
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
        mContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.header,null);
        addView(mContainer,lp);
        setGravity(Gravity.BOTTOM);
        mAnimation = (ImageView) findViewById(R.id.iv_header);
    }
    //设置状态
    public void setState(int state){
        //正常状态
        if (state == currentStatus) return ;
        //下拉状态
        if (state==STATUS_PULL)
        {
            mAnimation.clearAnimation();
            mAnimation.setBackgroundResource(R.drawable.pull_refresh);
            mAnimationDrawable_pull= (AnimationDrawable) mAnimation.getBackground();
            mAnimationDrawable_pull.start();
            mAnimation.setVisibility(View.VISIBLE);
        }
        //正在刷新
        if (state == STATUS_REFRESHING) {
            mAnimation.clearAnimation();
            mAnimation.setBackgroundResource(R.drawable.refreshing);
            mAnimationDrawable_refreshing = (AnimationDrawable) mAnimation.getBackground();
            mAnimationDrawable_refreshing.start();
           mAnimation.setVisibility(View.VISIBLE);
        }
        currentStatus=state;
    }
    //设置头部高度
    public void setVisiableHeight(int height){
        if (height<0)
            height=0;
        //获取view的布局参数
        LinearLayout.LayoutParams lp = (LayoutParams) mContainer.getLayoutParams();
        lp.height = height;
        //header设置参数
        mContainer.setLayoutParams(lp);


    }
    //获取头部高度
    public  int  getVisiableHeight(){
        return  mContainer.getLayoutParams().height;
    }
}

