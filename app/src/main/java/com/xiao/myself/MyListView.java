package com.xiao.myself;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Scroller;

import com.example.xiao.sendmessagetest.R;

/**
 * Created by xiao on 2015/11/30.
 * 自定义ListView
 */
public class MyListView extends ListView implements AbsListView.OnScrollListener {
    //HeaderView
    private MyHeaderView myHeaderView;
    private LinearLayout mHeaderContent;
    //记录Header的高度
    private int mHeaderHeight;
    //是否可以下拉刷新
    private boolean isEnablePull=true;
    //正在刷新
    private boolean mPullRefreshing = false;
    //Scroller实现平滑移动效果
    private Scroller mScroller;
    //恢复时间
    private int DEFAULT_DURATION =400;
    //最后一次的Y值
    private float mLastY =-1;
    private final static float OFFSET_RADIO = 1.8f;
    //自定义Interface
    private MyListViewListener myListViewListener;
    //滑动监视器
    private OnScrollListener mScrollListener;
    public MyListView(Context context) {
        super(context);
        init();
    }


    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        super.setOnScrollListener(this);
        mScroller = new Scroller(getContext(),new DecelerateInterpolator());
        myHeaderView = new MyHeaderView(getContext());
        mHeaderContent = (LinearLayout) myHeaderView.findViewById(R.id.ll_header);
        addHeaderView(myHeaderView);
        /**
         * 获取控件的高度
         * */
        //当在一个视图树中全局布局发生改变或者视图树中的
        // 某个视图的可视状态发生改变时，所要调用的回调函数的接口类
        myHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mHeaderHeight = mHeaderContent.getHeight();
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    //停止刷新
    public void stopRefresh(){
        //如果正在刷新
        if (mPullRefreshing){
            //刷新状态变成false
            mPullRefreshing=false;
            resetHeaderHeight();
        }
    }
    //重置头部高度
    private void resetHeaderHeight() {
        //headerView的可见高度
        int height = myHeaderView.getVisiableHeight();
        //headerView在隐藏
        if (height==0)return;
        //可以滑动并且可见高度小于headerView高度
        if (height<=mHeaderHeight&&mPullRefreshing){
            return;
        }
        int finalHeight = 0;
        if (height>mHeaderHeight&&mPullRefreshing){
            finalHeight=mHeaderHeight;
        }
        //(0,height)开始X，Y坐标 (0,finalHeight-height)结束坐标
        mScroller.startScroll(0,height,0,finalHeight-height,DEFAULT_DURATION);
        invalidate();
    }

    @Override
    public void setOnScrollListener(OnScrollListener l) {
        mScrollListener=l;
    }
    //滑动状态改变
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (mScrollListener!=null){
            mScrollListener.onScrollStateChanged(view,scrollState);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (mScrollListener!=null){
            //view,第一个可见view的id，可见item的总数，view中总共的item
            mScrollListener.onScroll(view,firstVisibleItem,visibleItemCount,totalItemCount);
        }
    }
    //复写View的onTouchEvent()

    //调用ScrollListener
    private void invokeOnScrolling() {
        // instanceof 测试它左边的对象是否是它右边的类的实例
        if(mScrollListener instanceof OnXScrollListener){
           OnXScrollListener sl= (OnXScrollListener) mScrollListener;
            sl.onXScrolling(this);
        }

    }
    //更新头部高度状态
    private void updateHeaderHeight(float delta) {
        myHeaderView.setVisiableHeight((int) (delta+myHeaderView.getVisiableHeight()));
        //可以滑动并且正在刷新
        if (isEnablePull&&mPullRefreshing){
            //如果header的可见高度大于头部高度
            if (myHeaderView.getVisiableHeight()>mHeaderHeight){
                //设置状态正在刷新
                myHeaderView.setState(MyHeaderView.STATUS_PULL);
            }
            else {
                myHeaderView.setState(MyHeaderView.STATUS_NORMAL);

            }
        }
        setSelection(0);
    }

    @Override
    public void computeScroll() {
        //如果进行了移动
        if (mScroller.computeScrollOffset()){//如果mScroller没有调用startScroll，这里将会返回false。
            myHeaderView.setVisiableHeight(mScroller.getCurrY());
            postInvalidate();
            invokeOnScrolling();
        }
        super.computeScroll();
    }
    public void setMyListViewListener(MyListViewListener l){
        myListViewListener = l;

    }
    //是否可以进行刷新
    public void setPullRefresh(boolean enable){
        mPullRefreshing = enable;
        //如果不可以进行刷新，那header就不可见
        if(!mPullRefreshing){
            mHeaderContent.setVisibility(View.INVISIBLE);

        }
        else {
            mHeaderContent.setVisibility(View.VISIBLE);
        }


    }
    //自定义ScrollListener
   public interface OnXScrollListener extends AbsListView.OnScrollListener{
        public void onXScrolling(View view);
    }
    //自定义ListView监听器
    public interface MyListViewListener {
        //刷新函数
        public void onRefresh();
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mLastY==-1){
            mLastY= ev.getRawY();
        }
        switch (ev.getAction()){
            //按下的时候
            case MotionEvent.ACTION_DOWN:
                mLastY=ev.getRawY();
                break;
            //移动
            case MotionEvent.ACTION_MOVE:
                final float deltaY = ev.getRawY()-mLastY;
                mLastY = ev.getRawY();
                //第一个可见位置在顶部并且头部高度大于0

                if (getFirstVisiblePosition()==0&&(mHeaderHeight>0||deltaY>0)){
                    //更新头部高度
                    updateHeaderHeight(deltaY/OFFSET_RADIO);
                    //调用这个方法
                    invokeOnScrolling();
                }
                break;
            default:
                mLastY=-1;
                //header不可见

                //返回显示在屏幕上的第一个元素在适配器中所处的位置
                if (getFirstVisiblePosition()==0){
                    //可以滑动并且可见高度大于view高度

                    if (isEnablePull&&myHeaderView.getVisiableHeight()>mHeaderHeight){
                        //正在下拉
                        mPullRefreshing=true;
                        //headerView的状态设置为正在下拉
                        myHeaderView.setState(MyHeaderView.STATUS_REFRESHING);

                        if (myListViewListener!=null){
                            myListViewListener.onRefresh();
                        }
                    }
                    //重置头部高度
                    resetHeaderHeight();
                }
                break;

        }
        return super.onTouchEvent(ev);
    }
}


