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

public class RegisterActivity extends AppCompatActivity {

    ImageView image2;
    TextView top_login2,top_signup2,low_signup;
    EditText email_s,password_s,confirm_pass;
    Button signUp_button;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        image2 = findViewById(R.id.image_id2);
        top_login2 = findViewById(R.id.top_login2);
        top_signup2 = findViewById(R.id.top_signup2);
        email_s = findViewById(R.id.s_email_id);
        password_s = findViewById(R.id.s_pass_id);
        confirm_pass = findViewById(R.id.s_conPass_id);
        signUp_button = findViewById(R.id.signup_button_s);

        fAuth = FirebaseAuth.getInstance();

        top_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String fullName = registerFullName.getText().toString();
                String email = email_s.getText().toString();
                String password = password_s.getText().toString();
                String confPass = confirm_pass.getText().toString();


                if(email.isEmpty())
                {
                    email_s.setError("Valid Email is required!");
                    return;
                }
                if(password.isEmpty())
                {
                    password_s.setError("Password is required!");
                    return;
                }
                if(confPass.isEmpty())
                {
                    confirm_pass.setError("Confirmation password is required!");
                    return;
                }
                if(!password.equals(confPass))
                {
                    confirm_pass.setError("Password don't match!");
                }
                Toast.makeText(RegisterActivity.this, "Data validated", Toast.LENGTH_SHORT).show();



                fAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        //finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}