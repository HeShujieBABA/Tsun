package com.myproject.tsun;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.lzy.widget.AlphaIndicator;
import com.myproject.tsun.fragment.HomeFragment;
import com.myproject.tsun.fragment.MeFragment;
import com.myproject.tsun.fragment.FindFragment;
import com.myproject.tsun.fragment.CourseFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private AlphaIndicator alphaIndicator;
    private MainAdapter adapter;
    private long exitTime = 0;
    //private SwipeRefreshLayout mainSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        initView();
        //初始化刷新
          /**mainSwipeRefreshLayout.setColorSchemeResources(R.color.colorStatusBar);
          mainSwipeRefreshLayout.setProgressViewEndTarget(true,250);
          mainSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshMain();
            }
        });**/
        //初始化底部的四个Fragment
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CourseFragment());
        fragmentList.add(new FindFragment());
        fragmentList.add(new MeFragment());
        adapter = new MainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        alphaIndicator.setViewPager(viewPager);
    }
    public void initView(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        alphaIndicator = (AlphaIndicator) findViewById(R.id.alphaIndicator);
       // mainSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.mainSwipeRefreshLayout);
    }
    public void refreshMain(){
     //   mainSwipeRefreshLayout.setRefreshing(false);
    }
    class MainAdapter extends FragmentPagerAdapter {
        public MainAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            if(event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0){
                if((System.currentTimeMillis()-exitTime)>2000){
                    Toast.makeText(MainActivity.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                }else {
                    finish();
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
