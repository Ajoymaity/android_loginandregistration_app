package com.userlogin.loginandregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText text_email, text_password;
    Button btn_login_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDb = new DatabaseHelper(this);

        btn_login_data = (Button) findViewById(R.id.btn_login);

        text_email = (EditText) findViewById(R.id.edit_email);
        text_password = (EditText) findViewById(R.id.edit_password);

        btn_login_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = text_email.getText().toString();
                String password = text_password.getText().toString();

                boolean isValid = myDb.matchEmail(email, password);
                    if(isValid == true){
                        Toast.makeText(Login.this, "successfully login", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Login.this, "Worng email or password", Toast.LENGTH_SHORT).show();
                    }
                }

        });
    }
}
