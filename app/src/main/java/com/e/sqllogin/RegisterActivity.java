package com.e.sqllogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_passsword);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_passsword);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();

                if(pwd.equals(cnf_pwd)) {
                   long val = db.addUser(user,pwd);
                   if(val > 0){
                       Toast.makeText(RegisterActivity.this,"Anda telah registrasi",Toast.LENGTH_SHORT).show();
                       Intent moveToLogin =  new Intent(RegisterActivity.this,LoginActivity.class);
                       startActivity(moveToLogin);
                   }
                   else {
                       Toast.makeText(RegisterActivity.this,"Anda telah registrasi",Toast.LENGTH_SHORT).show();
                   }

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Registrasi Eror",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
