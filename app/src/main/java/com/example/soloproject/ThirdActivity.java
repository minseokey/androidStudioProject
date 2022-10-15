package com.example.soloproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        setTitle("모프 개인 과제 (3페이지)");

        Intent inIntent = getIntent();

        User loginedUser = inIntent.getParcelableExtra("loginedUser");

        Button information = (Button) findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginedUser != null){
                    Toast.makeText(getApplicationContext(),"사용자 계정은 " + loginedUser.getuserID() +"입니다.\n 사용자 이름은 " + loginedUser.getuserName() + "입니다.",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent questionIndent = new Intent(getApplicationContext(),User_Check.class);
                    startActivity(questionIndent);
                }
            }
        });
    }
}