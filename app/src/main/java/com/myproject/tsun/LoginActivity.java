package com.myproject.tsun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.myproject.tsun.util.MessageEvent;
import com.myproject.tsun.util.MyDatabaseHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by 何书杰 on 2017/11/6.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "LoginActivity";
    private MyDatabaseHelper dbHelper;
    private Button btnLogin;
    private EditText etUserName,etUserPassWord;
    private TextView tvRegister;
    private Toolbar loginToolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        //注册EventBus
        if (!EventBus.getDefault().isRegistered(this))
        {
            EventBus.getDefault().register(this);
        }
        initView();
        setSupportActionBar(loginToolbar);
        dbHelper = new MyDatabaseHelper(LoginActivity.this,"UserForm.db",null,1);
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }
    public void initView(){
        loginToolbar = (Toolbar) findViewById(R.id.login_toolbar);
        loginToolbar.setTitle("");
        btnLogin = (Button) findViewById(R.id.btnLogin);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etUserPassWord = (EditText) findViewById(R.id.etUserPassWord);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
                //查询数据库中的数据
                Cursor cursor = sqLiteDatabase.query("User",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        String username = cursor.getString(cursor.getColumnIndex("username"));
                        String password = cursor.getString(cursor.getColumnIndex("password"));
                        if(etUserName.getText().toString().equals(username) && etUserPassWord.getText().toString().equals(password)){
                            Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
                            //存储本地信息
                            SharedPreferences.Editor editor = getSharedPreferences("user_data",MODE_PRIVATE).edit();
                            editor.putString("username",username);
                            editor.putString("password",password);
                            editor.putBoolean("isLogin",true);
                            editor.commit();
                            //EventBus发送POST消息
                            EventBus.getDefault().post(new MessageEvent("Login Success"));
                            break;
                        }
                    }while (cursor.moveToNext());
                }
                break;
            case R.id.tvRegister:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:
                break;
        }
    }
    @Subscribe
    public void onEvent(MessageEvent event) {
        //Toast.makeText(LoginActivity.this, event.msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.activity_open,R.anim.activity_close);
    }
}
