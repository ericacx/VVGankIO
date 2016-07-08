package com.gank.io.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gank.io.R;
import com.gank.io.adapter.RecyclerAdapter;
import com.gank.io.presenter.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

//只处理 view 操作
public class MainActivity extends AppCompatActivity implements OperatorView {
    private MainActivityPresenter mainActivityPresenter;//presenter

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swipeRefreshLayout;

    int lastVisibleItem = 0;
    LinearLayoutManager layoutManager;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivityPresenter = new MainActivityPresenter();
        mainActivityPresenter.attachView(this,this);
        mainActivityPresenter.initData();
        initView();
    }

    @Override
    public void initView() {
        //初始化 recyclerview
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if (mainActivityPresenter.recyclerAdapter == null) {
            mainActivityPresenter.recyclerAdapter = new RecyclerAdapter(this, mainActivityPresenter.mData);
            recyclerView.setAdapter(mainActivityPresenter.recyclerAdapter);
        }

        //初始化 swipeRefreshLayout
        swipeRefreshLayout.setColorSchemeResources(R.color.color_blue);
        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mainActivityPresenter.refresh();//data:刷新数据
                    }
                }).start();
            }
        });

        //加载更多
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //是最后一条,并且现在没正在滚动
                if (lastVisibleItem + 1 == mainActivityPresenter.recyclerAdapter.getItemCount()) {
                    mainActivityPresenter.loadMore();// data:加载更多
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();//获取最后一条的位置
            }
        });
    }

    @Override
    public void setRefreshing(boolean refreshing) {
        swipeRefreshLayout.setRefreshing(false);
    }
}
