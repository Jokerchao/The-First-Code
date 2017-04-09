package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.broadcastbestpractice.BaseActivity;

public class LoginActivity extends BaseActivity {

    private EditText passwordEdit;
    private EditText accountEdit;
    private Button Btn_Login;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);

        passwordEdit= (EditText) findViewById(R.id.password);
        accountEdit= (EditText) findViewById(R.id.account);
        Btn_Login= (Button) findViewById(R.id.login);

        Btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                if(account.equals("admin")&&password.equals("123456")){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"accout or password invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}