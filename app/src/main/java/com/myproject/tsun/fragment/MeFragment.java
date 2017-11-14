package com.myproject.tsun.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myproject.tsun.AboutUsActivity;
import com.myproject.tsun.LoginActivity;
import com.myproject.tsun.NewsContentActivity;
import com.myproject.tsun.R;
import com.myproject.tsun.SelfCenterActivity;
import com.myproject.tsun.SettingActivity;
import com.myproject.tsun.util.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by 何书杰 on 2017/10/20.
 */

public class MeFragment extends Fragment implements View.OnClickListener{
    private LinearLayout linearLayout_1,linearLayout_2,linearLayout_3,linearLayout_4,linearLayout_5,linearLayout_6,linearLayout_7,linearLayout_8,linearLayout_9;
    private RelativeLayout loginLayout;
    private TextView tvUserNickName;
    private CircleImageView circleImageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me,container,false);
        if (!EventBus.getDefault().isRegistered(this))
        {
            EventBus.getDefault().register(this);
        }

        //初始化控件
        linearLayout_1 = (LinearLayout) view.findViewById(R.id.layout_1);
        linearLayout_2 = (LinearLayout) view.findViewById(R.id.layout_2);
        linearLayout_3 = (LinearLayout) view.findViewById(R.id.layout_3);
        linearLayout_4 = (LinearLayout) view.findViewById(R.id.layout_4);
        linearLayout_5 = (LinearLayout) view.findViewById(R.id.layout_5);
        linearLayout_6 = (LinearLayout) view.findViewById(R.id.layout_6);
        linearLayout_7 = (LinearLayout) view.findViewById(R.id.layout_7);
        linearLayout_8 = (LinearLayout) view.findViewById(R.id.layout_8);
        linearLayout_9 = (LinearLayout) view.findViewById(R.id.layout_9);
        loginLayout = (RelativeLayout) view.findViewById(R.id.loginLayout);
        circleImageView = (CircleImageView) view.findViewById(R.id.circleImageView);
        tvUserNickName = (TextView) view.findViewById(R.id.tvUserNickName);
        //触发点击事件
        linearLayout_9.setOnClickListener(this);
        linearLayout_8.setOnClickListener(this);
        linearLayout_7.setOnClickListener(this);
        linearLayout_6.setOnClickListener(this);
        linearLayout_5.setOnClickListener(this);
        linearLayout_4.setOnClickListener(this);
        linearLayout_3.setOnClickListener(this);
        linearLayout_2.setOnClickListener(this);
        linearLayout_1.setOnClickListener(this);
        loginLayout.setOnClickListener(this);
        //存储操作
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("user_data",MODE_PRIVATE);
        Boolean isLogin = sharedPreferences.getBoolean("isLogin",false);
        if(isLogin) {
            String username = sharedPreferences.getString("username", "");
            //String password = sharedPreferences.getString("password", "");
            tvUserNickName.setText(username);
        }
        return view;
    }
    @Subscribe
    public void onEvent(MessageEvent event) {
        if(event.msg.equals("Login Success")){

        }else {
            tvUserNickName.setText("Login Click Here");
        }
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
            case R.id.layout_6:
                break;
            case R.id.layout_7:
                startActivity(new Intent(getContext(), NewsContentActivity.class));
                break;
            case R.id.layout_8:
                startActivity(new Intent(getContext(), AboutUsActivity.class));
                break;
            case R.id.layout_9:
                startActivity(new Intent(getContext(), SettingActivity.class));
                break;
            case R.id.loginLayout:
                startActivity(new Intent(getContext(), LoginActivity.class));
                getActivity().overridePendingTransition(R.anim.activity_open,R.anim.activity_close);
               // startActivity(new Intent(getContext(), SelfCenterActivity.class));
                break;
            default:
                break;
        }
    }
}
