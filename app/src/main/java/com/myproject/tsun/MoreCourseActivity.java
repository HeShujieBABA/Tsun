package com.myproject.tsun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.myproject.tsun.adapter.MoreCourseAdapter;
import com.myproject.tsun.db.MoreCourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 何书杰 on 2017/10/30.
 */

public class MoreCourseActivity extends AppCompatActivity {
    private SwipeRefreshLayout moreLayout_refreshView;
    private RecyclerView moreLayout_recyclerView;
    private MoreCourse[] moreCourses = {new MoreCourse(R.drawable.img1,"MySQL DBA及Linux运维工程师","时长：154课时","来源：我赢职场"),
            new MoreCourse(R.drawable.img2,"VR/AR虚拟现实全景动画师","时长：170课时","来源：我赢职场"),
            new MoreCourse(R.drawable.img3,"VR全景视频影视大师班","时长：134课时","来源：我赢职场"),
            new MoreCourse(R.drawable.img4,"超实用专业-VR动画挑战年薪20W","时长：354课时","来源：我赢职场")
    };
    private List<MoreCourse> moreCourseList = new ArrayList<>();
    private MoreCourseAdapter moreCourseAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_course_layout);
        initView();
        initCourse();
        //设置刷新
        moreLayout_refreshView.setColorSchemeResources(R.color.colorStatusBar);
        moreLayout_refreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshCourse();
            }
        });
        //设置recyclerView
        GridLayoutManager layoutManager = new GridLayoutManager(MoreCourseActivity.this,1);
        moreLayout_recyclerView.setHasFixedSize(true);
        moreLayout_recyclerView.setLayoutManager(layoutManager);
        moreCourseAdapter = new MoreCourseAdapter(moreCourseList);
        moreLayout_recyclerView.setAdapter(moreCourseAdapter);
    }
    //初始化控件
    public void initView(){
        moreLayout_recyclerView = (RecyclerView) findViewById(R.id.moreLayout_recyclerView);
        moreLayout_refreshView = (SwipeRefreshLayout) findViewById(R.id.moreLayout_refreshView);
    }
    public void initCourse(){
        moreCourseList.clear();
        for(int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(moreCourses.length);
            moreCourseList.add(moreCourses[index]);
        }
    }
    public void refreshCourse(){
        initCourse();
        moreLayout_refreshView.setRefreshing(false);
    }
}
