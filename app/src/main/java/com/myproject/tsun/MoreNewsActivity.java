package com.myproject.tsun;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.myproject.tsun.adapter.NewsAdapter;
import com.myproject.tsun.db.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 何书杰 on 2017/11/1.
 */

public class MoreNewsActivity extends AppCompatActivity {
    private SwipeRefreshLayout moreNewsLayout_refreshView;
    private RecyclerView moreNewsLayout_recyclerView;
    private News[] newses = {new News(R.drawable.img1,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.09.22"),
            new News(R.drawable.img2,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.08.22"),
            new News(R.drawable.img3,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.07.22"),
            new News(R.drawable.img4,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.06.22"),
            new News(R.drawable.img1,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.05.22"),
            new News(R.drawable.img2,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.04.22")};
    private List<News> newsList = new ArrayList<>();
    private NewsAdapter  newsAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_news_layout);
        initView();
        initNews();
        //刷新设置
        moreNewsLayout_refreshView.setColorSchemeResources(R.color.colorStatusBar);
       moreNewsLayout_refreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               refreshNews();
           }
       });
        //设置recyclerView
        GridLayoutManager layoutManager = new GridLayoutManager(MoreNewsActivity.this,1);
        moreNewsLayout_recyclerView.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(newsList);
        moreNewsLayout_recyclerView.setAdapter(newsAdapter);
    }
    public void initView(){
        moreNewsLayout_refreshView = (SwipeRefreshLayout) findViewById(R.id.moreNewsLayout_refreshView);
        moreNewsLayout_recyclerView = (RecyclerView) findViewById(R.id.moreNewsLayout_recyclerView);
    }
    public void initNews(){
        newsList.clear();
        for(int i =0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(newses.length);
            newsList.add(newses[index]);
        }
    }
    public void refreshNews(){
        initNews();
        moreNewsLayout_refreshView.setRefreshing(false);
    }
}
