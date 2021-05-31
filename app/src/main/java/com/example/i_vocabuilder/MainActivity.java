package com.example.i_vocabuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ImageView image1;
    TextView top_login,top_signup1,forgot_pass,no_account,low_signup;
    EditText email,password;
    Button login_button;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.image_id1);
        top_login = findViewById(R.id.top_login1);
        email = findViewById(R.id.edit_amail_id);
        password = findViewById(R.id.edit_password_id);
        forgot_pass = findViewById(R.id.forgot_pass_id);
        no_account = findViewById(R.id.no_account_id);
        login_button = findViewById(R.id.login_button_id);

        firebaseAuth = FirebaseAuth.getInstance();

        top_signup1 = findViewById(R.id.top_signup1);
        top_signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
        low_signup = findViewById(R.id.low_sign_up);
        low_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //extract/validation

                if(email.getText().toString().isEmpty())
                {
                    email.setError("Email is Missing!");
                    return;
                }
                if(password.getText().toString().isEmpty())
                {
                    password.setError("Password is Missing");
                    return;
                }
                //login user
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),MainInterface.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}