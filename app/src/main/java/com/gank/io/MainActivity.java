package com.gank.io;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gank.io.adapter.RecyclerAdapter;
import com.gank.io.bean.Message;
import com.gank.io.network.Api;
import com.gank.io.network.Result;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerAdapter recyclerAdapter;
    private List<Message> mData = new ArrayList<>();
    int lastVisibleItem = 0;
    LinearLayoutManager layoutManager;
    //    private CompositeSubscription subscription = new CompositeSubscription();
    static Api api = new Api();
    Observable<Result<Message>> messageListCall;
    Subscriber<Result<Message>> subscriber;
    public int[] days = {31, 28, 30, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int month = 10;
    int day = 1;
    boolean isPull = true;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    swipeRefreshLayout.setRefreshing(false);
                    recyclerAdapter.notifyDataSetChanged();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }
    };

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initViews();
    }

    private void initViews() {
        //初始化 recyclerview
        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        if (recyclerAdapter == null) {
            recyclerAdapter = new RecyclerAdapter(this, mData);
            recyclerView.setAdapter(recyclerAdapter);
        }

        //初始化 swipeRefreshLayout
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.color_blue);
        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        isPull = true;
                        //刷新数据
                        initData();
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
                if (lastVisibleItem + 1 == recyclerAdapter.getItemCount()) {
                    isPull = false;

                    day++;
                    if (day > days[month - 1]) {
                        month = (month++) % 12;
                        day = 1;
                    }

                    initData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();//获取最后一条的位置
            }
        });
    }

    private void initData() {
        //请求数据
        messageListCall = api.getMessageList(month, day);
        subscriber = new Subscriber<Result<Message>>() {
            @Override
            public void onCompleted() {
                Log.e("onCompleted", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError", e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onNext(Result<Message> messages) {
                if (isPull) {
                    mData = messages.getResultList();
                } else {
                    mData.addAll(messages.getResultList());
                }
                recyclerAdapter.setmData(mData);

                mHandler.sendEmptyMessage(1);
            }
        };
        messageListCall.
                filter(new Func1<Result<Message>, Boolean>() {
                    @Override
                    public Boolean call(Result<Message> messages) {
                        return messages != null;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
