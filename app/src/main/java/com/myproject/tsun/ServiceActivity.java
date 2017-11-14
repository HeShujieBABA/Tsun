package com.myproject.tsun;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.myproject.tsun.fragment.FirstServiceFragment;
import com.myproject.tsun.fragment.SecondServiceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 何书杰 on 2017/11/10.
 */

public class ServiceActivity extends AppCompatActivity {
    private String[] titles = {"本校","公开课联盟"};
    private TabLayout serviceTabLayout;
    private ViewPager serviceViewPager;
    private Toolbar serviceToolbar;
    private MyAdapter myAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
        initView();
        setSupportActionBar(serviceToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragmentList.add(new FirstServiceFragment());
        fragmentList.add(new SecondServiceFragment());
        myAdapter = new MyAdapter(getSupportFragmentManager());
        serviceViewPager.setAdapter(myAdapter);
        serviceTabLayout.setupWithViewPager(serviceViewPager);
    }
    public void initView(){
        serviceToolbar = (Toolbar) findViewById(R.id.service_toolbar);
        serviceToolbar.setTitle(" ");
        serviceTabLayout = (TabLayout) findViewById(R.id.serviceTabLayout);
        serviceViewPager = (ViewPager) findViewById(R.id.serviceViewPager);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        @Override
        public int getCount() {
            return fragmentList.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
