package com.example.soloproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class User_Check extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_check);

        Intent inintent = getIntent();
        LinearLayout subLayout = (LinearLayout) findViewById(R.id.ifNotRegister);

        Button registered = (Button) findViewById(R.id.registered);
        Button not_registered = (Button) findViewById(R.id.not_registered);
        Button goToRegister = (Button) findViewById(R.id.goToRegister);
        Button justWatch = (Button) findViewById(R.id.justWatch);

        //예 일때, 맨앞의 로그인 페이지로 이동
        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstpageIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(firstpageIntent);
            }
        });
        //아니오 일때, 뷰 뜨게 만들기
        not_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subLayout.setVisibility(View.VISIBLE);
            }
        });

        //회원가입 하러가기
        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondpageIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(secondpageIntent);
            }
        });

        // 돌아가서 그냥 보기
        justWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdpageIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(thirdpageIntent);
            }
        });



    }
}
