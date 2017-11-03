package com.myproject.tsun.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.myproject.tsun.R;


/**
 * Created by 何书杰 on 2017/10/20.
 */

public class CourseFragment extends Fragment implements View.OnClickListener{
    private LinearLayout linearLayout_1,linearLayout_2,linearLayout_3,linearLayout_4,linearLayout_5;
    private SwipeRefreshLayout courseFragment_refresh;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course,container,false);
        //初始化控件
        linearLayout_1 = (LinearLayout) view.findViewById(R.id.layout_1);
        linearLayout_2 = (LinearLayout) view.findViewById(R.id.layout_2);
        linearLayout_3 = (LinearLayout) view.findViewById(R.id.layout_3);
        linearLayout_4 = (LinearLayout) view.findViewById(R.id.layout_4);
        linearLayout_5 = (LinearLayout) view.findViewById(R.id.layout_5);
        courseFragment_refresh = (SwipeRefreshLayout) view.findViewById(R.id.courseFragment_refresh);

        //定义控件
        linearLayout_1.setOnClickListener(this);
        linearLayout_2.setOnClickListener(this);
        linearLayout_3.setOnClickListener(this);
        linearLayout_4.setOnClickListener(this);
        linearLayout_5.setOnClickListener(this);

        //刷新操作
        courseFragment_refresh.setColorSchemeResources(R.color.colorStatusBar);
        courseFragment_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout();
            }
        });
        return view;
    }
    public void refreshLayout(){
        courseFragment_refresh.setRefreshing(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_1:
                break;
            case R.id.layout_2:
                break;
            case R.id.layout_3:
                break;
            case R.id.layout_4:
                break;
            case R.id.layout_5:
                break;
            default:
                break;
        }
    }
}
