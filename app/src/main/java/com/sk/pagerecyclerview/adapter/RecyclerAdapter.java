package com.sk.pagerecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sk.pagerecyclerview.R;
import com.sk.pagerecyclerview.bean.JavaBean;
import com.sk.pagerecyclerview.widget.pagerecycler.ScreenSizeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sk on 16/9/14.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PageViewHolder> {

    public Context mContext;
    public List<JavaBean> mDatas = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public PageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_data, null);
        return new PageViewHolder(view);
    }


    public void update(List<JavaBean> moeItemDatas, boolean isClear) {
        if (isClear)
            this.mDatas.clear();
        if (moeItemDatas != null && !moeItemDatas.isEmpty()) {
            this.mDatas.addAll(moeItemDatas);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(PageViewHolder holder, int position) {
        JavaBean javaBean = mDatas.get(position);
        if (javaBean != null) {
            holder.tvData.setBackgroundColor(mContext.getResources().getColor(android.R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    /**
     * 设置img高度
     *
     * @param target
     */
    private void getImgHeight(ImageView target) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) target.getLayoutParams();
        int padding = ScreenSizeUtils.dp2px(mContext, 1) * 2;
        params.width = (int) (ScreenSizeUtils.getScreenWidth(mContext) / 4) - padding;
    }


    class PageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_data)
        ImageView tvData;


        public PageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            getImgHeight(tvData);
        }
    }
}
