package com.myproject.tsun;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.kyleduo.switchbutton.SwitchButton;
/**
 * Created by 何书杰 on 2017/11/4.
 */

public class SettingActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar setting_Toobar;
    private SwitchButton btnSwitch;
    private TextView setting_textView,setting_version;
    private static String versionName;
    private LinearLayout layout_4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);
        setting_Toobar = (Toolbar) findViewById(R.id.setting_toolbar);
        setting_Toobar.setTitle("");
        setSupportActionBar(setting_Toobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setting_textView = (TextView) findViewById(R.id.setting_textView);
        //版本更新
        setting_version  =(TextView) findViewById(R.id.setting_veision);
        layout_4 = (LinearLayout) findViewById(R.id.layout_4);
        layout_4.setOnClickListener(this);
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(),0);
            versionName = packageInfo.versionName;
        }catch (Exception e){
            e.printStackTrace();
        }
        setting_version.setText("当前版本号："+versionName);
        //滑动按钮
        btnSwitch = (SwitchButton) findViewById(R.id.setting_switchButton);
        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    setting_textView.setVisibility(View.VISIBLE);
                }else {
                    setting_textView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_4:
                Toast.makeText(SettingActivity.this,"当前已经是最新版本",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
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
        return  true;
    }
}
