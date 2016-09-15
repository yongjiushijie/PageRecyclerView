package com.sk.pagerecyclerview.widget.pagerecycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by sk on 2016/7/15.
 * recycler 水平分页操作
 * 使用范围：我的衣橱，背景商店，美容院，服装店
 */
public class PageRecyclerView extends BaseRecyclerView {

    private float downX;
    private float MIN_DISTANCE = 50;

    private int Max_Num = 8;
    private int totalPage;
    private int currentPage = 1;
    private float mScrollX = 0;


    private final int width = ScreenSizeUtils.getScreenWidth(getContext());


    public PageRecyclerView(Context context) {
        super(context);
    }

    public PageRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PageRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        currentPage = 1;
        mScrollX = 0;
        totalPage = getAdapter().getItemCount() / Max_Num;
    }

    /**
     * 回復原狀態
     */
    public void setDefault() {
        currentPage = 1;
        mScrollX = 0;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = e.getX();
                break;
        }
        return super.onInterceptTouchEvent(e);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                float slideDistance = e.getX() - downX;
                if (Math.abs(slideDistance) > MIN_DISTANCE) {
                    if (slideDistance > 0) {//手势左滑
                        // TODO: 上一页
                        currentPage = currentPage == 1 ? 1 : currentPage - 1;
                    } else {//手势右滑
                        // TODO: 下一页
                        currentPage = currentPage == totalPage ? totalPage : currentPage + 1;
                    }
                }
                smoothScrollBy((int) ((currentPage - 1) * width - mScrollX), 0);
                return true;
        }
        return super.onTouchEvent(e);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        mScrollX += dx;
        super.onScrolled(dx, dy);
    }
}
