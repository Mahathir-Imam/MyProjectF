package com.example.i_vocabuilder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddingWord extends AppCompatActivity {

    TextView text1,text2,text3;
    EditText word,meaning,explanation;
    Button addButton;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_word);

        text1 = findViewById(R.id.setWord);
        text2 = findViewById(R.id.meaningid);
        text3 = findViewById(R.id.sentenceid);
        word = findViewById(R.id.word);
        meaning = findViewById(R.id.meaning);
        explanation = findViewById(R.id.explanation);
        addButton = findViewById(R.id.buttonAdd);

        // mRootRef = new Firebase("https://myproject-978ae-default-rtdb.firebaseio.com/");

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Userinfo");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Get all the values
                String Edit1 = word.getText().toString();
                String Edit2 = meaning.getText().toString();
                String Edit3 = explanation.getText().toString();

                if(Edit1.isEmpty() || Edit2.isEmpty() || Edit3.isEmpty())
                {
                    Toast.makeText(AddingWord.this, "Please, Complete the field", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String userid = reference.push().getKey();
                    UserHelperClass userHelperClass = new UserHelperClass();
                    userHelperClass.setWord(Edit1);
                    userHelperClass.setMeaning(Edit2);
                    userHelperClass.setExplanation(Edit3);

                    reference.child(userid).setValue(userHelperClass, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                           if(error == null)
                           {
                               Toast.makeText(AddingWord.this, "Sucessfully,data inserted", Toast.LENGTH_SHORT).show();
                               //startActivity(new Intent(getApplicationContext(), RetrieveData.class));
                           }
                           else
                           {
                               Toast.makeText(AddingWord.this, "Some error", Toast.LENGTH_SHORT).show();
                           }
                        }
                    });

                }



            }
        });

    }
}