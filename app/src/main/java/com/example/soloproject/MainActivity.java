package com.example.soloproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.Edits;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("모프 개인 과제 (1페이지)");

        Intent inintent = getIntent();

        //메인의 버튼 3개
        Button shoppingMall = (Button)findViewById(R.id.shoppingMall);
        Button login = (Button)findViewById(R.id.Login);
        Button register = (Button)findViewById(R.id.Register);



        //테스트 계정 생성

        User testUser = new User("hello","123123123","모프과제","010-8960-2817","국민대학교");
        UserSet.userSet.add(testUser);

        //메뉴로 이동 버튼은 아무정보 없이 쇼핑몰 페이지로 넘어간다.
        shoppingMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mallIntent = new Intent(getApplicationContext(),ThirdActivity.class);
                mallIntent.putExtra("loginedUser", (User) null);
                startActivity(mallIntent);
            }
        });
        // 회원가입 버튼은 아무정보 없이 회원가입 페이지로 넘어간다.
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(registerIntent);
            }
        });

        //로그인 버튼을 누르면 회원정보에 지금 넣은 ID,passWord를 확인하고,
        //만약 존재한다면 그 회원객체를 넘기고 아니면 Toast로 다시 시도해달라고 띄운다.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ID = (EditText) findViewById(R.id.idInput);
                EditText password = (EditText) findViewById(R.id.passwordInput);
                for (User ifUser : UserSet.userSet) {
                    if (ifUser.getuserID().equals(ID.getText().toString()) && ifUser.getuserPassword().equals(password.getText().toString())) {
                        Intent loginIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                        loginIntent.putExtra("loginedUser", ifUser);
                        startActivity(loginIntent);
                        return;
                    }
                }
                Toast.makeText(getApplicationContext(), "다시 시도해 주세요",Toast.LENGTH_SHORT).show();
            }
        });
    }

}