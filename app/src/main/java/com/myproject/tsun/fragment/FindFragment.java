package com.myproject.tsun.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myproject.tsun.R;
import com.myproject.tsun.adapter.FindItemAdapter;
import com.myproject.tsun.db.FindItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 何书杰 on 2017/10/20.
 */

public class FindFragment extends Fragment {
    private SwipeRefreshLayout findFragment_refresh;
    private RecyclerView findFragment_recyclerView;
    private FindItem[] findItems = {new FindItem(R.drawable.me,"精品课程"),
    new FindItem(R.drawable.me,"公开课联盟"),
    new FindItem(R.drawable.me,"直播课"),
    new FindItem(R.drawable.me,"服务"),
    new FindItem(R.drawable.me,"院系新闻")};
    private List<FindItem> findItemList = new ArrayList<>();
    private FindItemAdapter findItemAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find,container,false);
        initItem();
        //初始化控件
        findFragment_refresh = (SwipeRefreshLayout) view.findViewById(R.id.findFragment_refresh);
        findFragment_recyclerView = (RecyclerView) view.findViewById(R.id.findFragment_recyclerView);

        findFragment_refresh.setColorSchemeResources(R.color.colorStatusBar);
        findFragment_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout();
            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        findFragment_recyclerView.setLayoutManager(layoutManager);
        findFragment_recyclerView.setHasFixedSize(true);
        findItemAdapter = new FindItemAdapter(findItemList);
        findFragment_recyclerView.setAdapter(findItemAdapter);
        return view;
    }
    public void refreshLayout(){
        findFragment_refresh.setRefreshing(false);
    }
    public void initItem(){
        findItemList.clear();
        for(int i = 0;i<5;i++){
            findItemList.add(findItems[i]);
        }
    }
}
