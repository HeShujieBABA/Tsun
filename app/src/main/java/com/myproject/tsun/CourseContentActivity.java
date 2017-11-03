package com.myproject.tsun;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.myproject.tsun.fragment.ChapterFragment;
import com.myproject.tsun.fragment.ChatFragment;
import com.myproject.tsun.fragment.LiveFragment;
import com.myproject.tsun.fragment.QuestionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 何书杰 on 2017/11/1.
 */

public class CourseContentActivity extends AppCompatActivity {
    private String[] titles = {"章节","直播","聊天","问答"};
    private VideoView videoView;
    private List<Fragment> fragmentList;
    private TabLayout courseContent_tabLayout;
    private ViewPager courseContent_viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_content_layout);
        initView();
        addFragmentList();

        //本地视频
        String videoUrl_local = Environment.getExternalStorageDirectory().getPath()+"/fl1234.mp4";
        //网络视频
        String videoUrl_net = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        Uri uri = Uri.parse(videoUrl_net);
        //播放视频
        videoView.setMediaController(new MediaController(CourseContentActivity.this));
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
        videoView.setVideoURI(uri);
        videoView.start();

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        courseContent_viewPager.setAdapter(myAdapter);
        courseContent_tabLayout.setupWithViewPager(courseContent_viewPager);

    }
    public void addFragmentList(){
        fragmentList = new ArrayList<>();
        fragmentList.add(new ChapterFragment());
        fragmentList.add(new LiveFragment());
        fragmentList.add(new ChatFragment());
        fragmentList.add(new QuestionFragment());
    }
    public void initView(){
        videoView = (VideoView) findViewById(R.id.videoView);
        courseContent_tabLayout = (TabLayout) findViewById(R.id.courseContent_tabLayout);
        courseContent_viewPager = (ViewPager) findViewById(R.id.courseContent_viewPager);
    }
    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {
        @Override
        public void onCompletion(MediaPlayer mp) {
            //播放完成后的操作
            videoView.start();
        }
    }
    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
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
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus && Build.VERSION.SDK_INT>=19){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
