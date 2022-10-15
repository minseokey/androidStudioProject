package com.example.soloproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("모프 개인 과제 (2페이지)");

        Intent inIntent = getIntent();
        Validations.agreements = false;
        Validations.check = false;

        TextView terms = findViewById(R.id.terms);
        terms.setMovementMethod(new ScrollingMovementMethod());

        Button idConfirm = (Button)findViewById(R.id.idConfirm);
        Button register = (Button) findViewById(R.id.registerAgree);

        RadioGroup termsButton = (RadioGroup)findViewById(R.id.termsAgreements);
        termsButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.termsAgreementsYes){
                    Validations.agreements = true;
                }
                else if(i == R.id.termsAgreementsNo){
                    Validations.agreements = false;
                }
            }
        });

        EditText idMakeInput = (EditText) findViewById(R.id.idMakeInput);
        EditText passwordMakeInput = (EditText) findViewById(R.id.passwordMakeInput);
        EditText passwordConfirmInput = (EditText) findViewById(R.id.passwordConfirmInput);
        EditText nameMakeInput = (EditText) findViewById(R.id.nameMakeInput);
        EditText phoneNumberMakeInput = (EditText) findViewById(R.id.phoneNumberMakeInput);
        EditText addressMakeInput = (EditText) findViewById(R.id.addressMakeInput);

        //아이디 중복 검사
        idConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validations.check = false;
                for(User ifUser : UserSet.userSet){
                    if(!ifUser.getuserID().equals(idMakeInput.getText().toString()) && Validations.validateID(idMakeInput.getText().toString())){
                        Validations.check = true;
                    }
                }
                if (Validations.check){
                    Toast.makeText(getApplicationContext(),"등록 가능한 아이디 입니다.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"이미 등록된 아이디이거나 \n 조건에 맞지않는 아이디 입니다.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 회원가입 버튼 누를때, 정규식 함수로 유효선 검사
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Validations.check){
                    Toast.makeText(getApplicationContext(),"ID가 확인되지 않습니다.ID확인을 해주세요",Toast.LENGTH_SHORT).show();
                }
                // 비밀번호 적합도
                else if(!Validations.validatePassword(passwordMakeInput.getText().toString())){
                    Toast.makeText(getApplicationContext(),"비밀번호가 옳지 않습니다.",Toast.LENGTH_SHORT).show();
                }
                //id는 확인했고 나머지 들의 input이 옳은지 확인
                else if(!passwordConfirmInput.getText().toString().equals(passwordMakeInput.getText().toString())){
                    Toast.makeText(getApplicationContext(),"비밀번호 확인이 옳지 않습니다.",Toast.LENGTH_SHORT).show();
                }
                //전화번호 적합도
                else if(!Validations.validatePhone(phoneNumberMakeInput.getText().toString())){
                    Toast.makeText(getApplicationContext(),"전화번호가 옳지 않습니다.",Toast.LENGTH_SHORT).show();
                }
                else if(!Validations.agreements){
                    Toast.makeText(getApplicationContext(),"약관에 동의해 주세요",Toast.LENGTH_SHORT).show();
                }
                else{
                    User registingUser = new User(idMakeInput.getText().toString(),
                            passwordMakeInput.getText().toString(),
                            nameMakeInput.getText().toString(),
                            phoneNumberMakeInput.getText().toString(),
                            addressMakeInput.getText().toString());
                    UserSet.userSet.add(registingUser);
                    Intent loginIntent = new Intent(getApplicationContext(), MainActivity.class);
//                    loginIntent.putExtra("loginedUser", registingUser);
                    startActivity(loginIntent);
                }
            }
        });

    }
}