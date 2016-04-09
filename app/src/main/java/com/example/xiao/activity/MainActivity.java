package com.example.xiao.activity;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;

import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;


import com.example.xiao.sendmessagetest.R;
import com.fragment.ApolloFragment;
import com.fragment.DealFragment;
import com.fragment.MoreFragment;
import com.fragment.UserFragment;
import com.xiao.myself.MyViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiao on 2015/11/2.
 * 主界面
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private DealFragment mDealFragment; //团购
    private ApolloFragment mApolloFragment;//上门
    private UserFragment mUserFragment;//我的
    private MoreFragment mMoreFragment;//更多
    private MyViewPager mViewpager;
    private List<Fragment> mDatas;
    private FragmentPagerAdapter mAdapter;
    private ImageView user,apollo,deal,more;
    private TextView user_tv,apollo_tv,deal_tv,more_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initData();
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mDatas.get(position);
            }

            @Override
            public int getCount() {
                return mDatas.size();
            }
        };
      mViewpager.setAdapter(mAdapter);
    }
    private void initData() {
        mDatas = new ArrayList<>();
        mApolloFragment = new ApolloFragment();
        mDealFragment = new DealFragment();
        mUserFragment = new UserFragment();
        mMoreFragment = new MoreFragment();
        mDatas.add(mDealFragment);
        mDatas.add(mApolloFragment);
        mDatas.add(mUserFragment);
        mDatas.add(mMoreFragment);


    }

    private void initview() {
        mViewpager = (MyViewPager) findViewById(R.id.main_viewPager);
        user = (ImageView)findViewById(R.id.selector_user);
        user_tv = (TextView) findViewById(R.id.selector_user_tv);
        user.setOnClickListener(this);
        apollo = (ImageView)findViewById(R.id.selector_apollo);
        apollo_tv = (TextView) findViewById(R.id.selector_apollo_tv);
        apollo.setOnClickListener(this);
        more = (ImageView)findViewById(R.id.selector_more);
        more_tv = (TextView) findViewById(R.id.selector_more_tv);
        more.setOnClickListener(this);
        deal = (ImageView)findViewById(R.id.selector_deal);
        deal_tv= (TextView) findViewById(R.id.selector_deal_tv);
        deal.setOnClickListener(this);
        deal.setSelected(true);
        deal_tv.setTextColor(getResources().getColor(R.color.meituan));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.selector_deal:
                mViewpager.setCurrentItem(0);
                deal.setSelected(true);
                apollo.setSelected(false);
                user.setSelected(false);
                more.setSelected(false);
                deal_tv.setTextColor(getResources().getColor(R.color.meituan));
                apollo_tv.setTextColor(getResources().getColor(R.color.gray));
                user_tv.setTextColor(getResources().getColor(R.color.gray));
                more_tv.setTextColor(getResources().getColor(R.color.gray));

                break;
            case R.id.selector_apollo:
                mViewpager.setCurrentItem(1);
                deal.setSelected(false);
                apollo.setSelected(true);
                user.setSelected(false);
                more.setSelected(false);
                deal_tv.setTextColor(getResources().getColor(R.color.gray));
                apollo_tv.setTextColor(getResources().getColor(R.color.meituan));
                user_tv.setTextColor(getResources().getColor(R.color.gray));
                more_tv.setTextColor(getResources().getColor(R.color.gray));
                break;
            case R.id.selector_user:
                mViewpager.setCurrentItem(2);
                deal.setSelected(false);
                apollo.setSelected(false);
                user.setSelected(true);
                more.setSelected(false);
                deal_tv.setTextColor(getResources().getColor(R.color.gray));
                apollo_tv.setTextColor(getResources().getColor(R.color.gray));
                user_tv.setTextColor(getResources().getColor(R.color.meituan));
                more_tv.setTextColor(getResources().getColor(R.color.gray));

                break;
            case R.id.selector_more:
                mViewpager.setCurrentItem(3);
                deal.setSelected(false);
                apollo.setSelected(false);
                user.setSelected(false);
                more.setSelected(true);
                deal_tv.setTextColor(getResources().getColor(R.color.gray));
                apollo_tv.setTextColor(getResources().getColor(R.color.gray));
                user_tv.setTextColor(getResources().getColor(R.color.gray));
                more_tv.setTextColor(getResources().getColor(R.color.meituan));
                break;

        }
    }
}
