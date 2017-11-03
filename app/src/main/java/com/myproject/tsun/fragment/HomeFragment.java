package com.myproject.tsun.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.myproject.tsun.MoreCourseActivity;
import com.myproject.tsun.MoreNewsActivity;
import com.myproject.tsun.R;
import com.myproject.tsun.adapter.CourseAdapter;
import com.myproject.tsun.adapter.NewsAdapter;
import com.myproject.tsun.db.Course;
import com.myproject.tsun.db.News;
import com.myproject.tsun.util.FullyGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 何书杰 on 2017/10/20.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{
    private SwipeRefreshLayout homeSwipeRefreshLayout;
    private RollPagerView rollPagerView;
    private Course[] courses = {new Course(R.drawable.img1,"Java","来源：我赢职场"),
            new Course(R.drawable.img2,"C++","来源：我赢职场"),
            new Course(R.drawable.img3,"Android","来源：我赢职场"),
            new Course(R.drawable.img4,"Python","来源：我赢职场"),
            new Course(R.drawable.img1,"Ruby","来源：我赢职场"),
            new Course(R.drawable.img2,"Swift","来源：我赢职场")
    };
    private News[] newses = {new News(R.drawable.img1,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.09.22"),
            new News(R.drawable.img2,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.08.22"),
            new News(R.drawable.img3,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.07.22"),
            new News(R.drawable.img4,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.06.22"),
            new News(R.drawable.img1,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.05.22"),
            new News(R.drawable.img2,"北京沃赢科技股份有限公司地址搬迁公告","来源：我赢职场","2017.04.22")};
    private List<Course> courseList = new ArrayList<>();
    private List<News> newsList = new ArrayList<>();
    private CourseAdapter courseAdapter;
    private NewsAdapter newsAdapter;
    private RecyclerView recycler_view;
    private RecyclerView recyclerView;
    private TextView tvMore,tv_moreNews;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        initCourses();
        initNews();
        //初始化控件
        rollPagerView = (RollPagerView) view.findViewById(R.id.roll_view_pager);
        rollPagerView.setPlayDelay(2000);
        rollPagerView.setAnimationDurtion(500);
        rollPagerView.setAdapter(new HomeFragment.TestNormalAdapter());
        rollPagerView.setHintView(new ColorPointHintView(getContext(), Color.YELLOW,Color.WHITE));
        //加载视图
        recycler_view= (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        tvMore = (TextView) view.findViewById(R.id.more);
        tv_moreNews = (TextView) view.findViewById(R.id.tv_moreNews);
        tvMore.setOnClickListener(this);
        tv_moreNews.setOnClickListener(this);

        FullyGridLayoutManager layoutManager = new FullyGridLayoutManager(getContext(),2);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setHasFixedSize(true);
        recycler_view.setNestedScrollingEnabled(false);
        courseAdapter = new CourseAdapter(courseList);
        recycler_view.setAdapter(courseAdapter);

        FullyGridLayoutManager fullyGridLayoutManager = new FullyGridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(fullyGridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        newsAdapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(newsAdapter);
        return view;
    }
    public void initCourses(){
        courseList.clear();
        for(int i=0;i<6;i++){
            Random random = new Random();
            int index = random.nextInt(courses.length);
            courseList.add(courses[index]);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.more:
                startActivity(new Intent(getContext(), MoreCourseActivity.class));
                break;
            case R.id.tv_moreNews:
                startActivity(new Intent(getContext(), MoreNewsActivity.class));
                break;
            default:
                break;
        }
    }

    public void initNews(){
        newsList.clear();
        for(int i=0;i<3;i++){
            Random random = new Random();
            int index = random.nextInt(newses.length);
            newsList.add(newses[index]);
        }
    }
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }
        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
