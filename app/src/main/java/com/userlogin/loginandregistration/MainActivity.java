package com.userlogin.loginandregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText text_email, text_password, text_cpassword;
    Button btn_register_data, btn_login_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        btn_register_data = (Button) findViewById(R.id.btn_register);
        btn_login_data = (Button) findViewById(R.id.btn_login);

        text_email = (EditText) findViewById(R.id.edit_email);
        text_password = (EditText) findViewById(R.id.edit_password);
        text_cpassword = (EditText) findViewById(R.id.edit_conpassword);


        btn_login_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });


        btn_register_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = text_email.getText().toString();
                String s2 = text_password.getText().toString();
                String s3 = text_cpassword.getText().toString();

                if(s1.equals("") || s2.equals("") || s3.equals("")){

                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s2.equals(s3)){
                        boolean chkemail = myDb.chkemail(s1);
                        if(chkemail == true) {
                            boolean isinsert = myDb.insert(s1, s2);
                            if (isinsert == true) {
                                Toast.makeText(MainActivity.this, "registered successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                                 Toast.makeText(MainActivity.this, "email alredy exists", Toast.LENGTH_SHORT).show();
                             }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}
