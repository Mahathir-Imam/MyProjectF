package com.example.i_vocabuilder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class RetrieveData extends AppCompatActivity {

    TextView tvfn,tvln,tvFullname;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data);

        tvfn = findViewById(R.id.tvFirstName);
        tvln = findViewById(R.id.tvLasttName);
        tvFullname = findViewById(R.id.tvFullName);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                String Edit1 = snapshot.child("Edit1").getValue(String.class);
                String Edit2 = snapshot.child("Edit2").getValue(String.class);
                String Edit3 = snapshot.child("Edit3").getValue(String.class);

                tvfn.setText(Edit1);
                tvln.setText(Edit2);
                tvFullname.setText(Edit3);

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }
}