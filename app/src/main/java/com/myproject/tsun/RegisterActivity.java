package com.myproject.tsun;

import android.content.ContentValues;
import android.content.Context;
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

/**
 * Created by 何书杰 on 2017/11/11.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar registerToolbar;
    private Button btnRegister;
    private TextView tvLogin;
    private EditText etRegisterUserName,etRegisterUserPassWord,etRegisterSurePassWord;
    private String username,password;
    private MyDatabaseHelper dbHelper;
    private Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        initView();
        setSupportActionBar(registerToolbar);
        dbHelper = new MyDatabaseHelper(RegisterActivity.this,"UserForm.db",null,1);
        btnRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                //使用EventBus的POST方法发送消息
                EventBus.getDefault().post(new MessageEvent("EventBus发送注册消息"));
                    if(etRegisterUserPassWord.getText().toString().equals(etRegisterSurePassWord.getText().toString())
                            && !etRegisterUserName.getText().toString().equals("")
                                && !etRegisterUserPassWord.getText().toString().equals("")
                                    && !etRegisterSurePassWord.getText().toString().equals("")){
                        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        //开始组装第一条数据
                        username = etRegisterUserName.getText().toString();
                        password = etRegisterUserPassWord.getText().toString();
                        contentValues.put("username",username);
                        contentValues.put("password",password);
                        sqLiteDatabase.insert("User",null,contentValues);
                        Toast.makeText(RegisterActivity.this,"注册成功，快去登录吧~",Toast.LENGTH_SHORT).show();

                        break;
                    }else {
                        Toast.makeText(RegisterActivity.this,"请重新确认你的账号和密码~",Toast.LENGTH_SHORT).show();
                    }
                break;
            case R.id.tvLogin:
                break;
        }
    }

    public void initView(){
        registerToolbar =  (Toolbar) findViewById(R.id.register_toolbar);
        registerToolbar.setTitle(" ");
        btnRegister = (Button) findViewById(R.id.btnRegister);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        etRegisterUserName = (EditText) findViewById(R.id.etRegisterUserName);
        etRegisterUserPassWord = (EditText) findViewById(R.id.etRegisterUserPassWord);
        etRegisterSurePassWord = (EditText) findViewById(R.id.etRegisterSureUserPassWord);
    }
}
