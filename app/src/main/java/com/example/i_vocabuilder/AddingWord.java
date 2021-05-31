package com.example.i_vocabuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
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

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                //Get all the values
                String Edit1 = word.getText().toString();
                String Edit2 = meaning.getText().toString();
                String Edit3 = explanation.getText().toString();

                UserHelperClass helperClass = new UserHelperClass(Edit1,Edit2,Edit3);

                reference.child(Edit1).setValue(helperClass);


                word.setText("");
                meaning.setText("");
                explanation.setText("");

                Toast.makeText(getApplicationContext(),"Value Inserted",Toast.LENGTH_SHORT).show();

            }
        });

    }
}