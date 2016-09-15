package com.sk.pagerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.sk.pagerecyclerview.adapter.RecyclerAdapter;
import com.sk.pagerecyclerview.bean.JavaBean;
import com.sk.pagerecyclerview.widget.pagerecycler.BaseRecyclerView;
import com.sk.pagerecyclerview.widget.pagerecycler.PageRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_page)
    PageRecyclerView pageRecyclerView;

    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        pageRecyclerView.setLayoutManager(BaseRecyclerView.GRID, RecyclerView.HORIZONTAL, false, 2);
        mAdapter = new RecyclerAdapter(this);
        pageRecyclerView.setAdapter(mAdapter);
        setDatas();
    }

    private void setDatas() {
        JavaBean bean = null;
        List<JavaBean> datas = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            bean = new JavaBean();
            bean.setContent("PageRecycler__________" + i);
            datas.add(bean);
        }

        mAdapter.update(datas, true);
    }
}
