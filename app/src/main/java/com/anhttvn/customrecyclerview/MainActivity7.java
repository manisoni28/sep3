package com.anhttvn.customrecyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity7 extends AppCompatActivity {

    TextView textView, textView2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("product");
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<FruitItem> fruitItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                FruitItem fruitItem = new FruitItem();
                fruitItem.setWeight(100);
                fruitItem.setgId("g300");
                fruitItem.setgUrl("ewhfwehjkjkwejkfwejkfg");
                fruitItem.setCategory("action");
                fruitItem.setImage(100);
                fruitItem.setName("chal raha h");
                myRef.push().setValue(fruitItem);

                fruitItem = new FruitItem();
                fruitItem.setWeight(1200);
                fruitItem.setgId("g200");
                fruitItem.setgUrl("ewhfwehjkjkwejkfwejkfg");
                fruitItem.setCategory("action");
                fruitItem.setImage(100);
                fruitItem.setName("chal raha h");
                myRef.push().setValue(fruitItem);

                fruitItem = new FruitItem();
                fruitItem.setWeight(1920);
                fruitItem.setgId("g100");
                fruitItem.setgUrl("ewhfwehjkjkwejkfwejkfg");
                fruitItem.setCategory("action");
                fruitItem.setImage(100);
                fruitItem.setName("chal raha h");
                myRef.push().setValue(fruitItem);
            }
        });
        myAdapter = new MyAdapter(this, fruitItemArrayList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter.notifyDataSetChanged();
        fetchDataByFirebase();
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//                textView.setText(value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = dataSnapshot.getValue(String.class);
//                textView2.setText(value);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(MainActivity7.this, "ChildAdded", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(MainActivity7.this, "ChildChanged", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(MainActivity7.this, "ChildRemoved", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Toast.makeText(MainActivity7.this, "ChildmoVED", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void fetchDataByFirebase() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnaphot : dataSnapshot.getChildren()) {
                    FruitItem fruitItem = childDataSnaphot.getValue(FruitItem.class);
                    Log.i("fruitName", fruitItem.getName());
                    fruitItemArrayList.add(fruitItem);
                    myAdapter.notifyDataSetChanged();

                }
//                String value = dataSnapshot.getValue(String.class);
//                textView.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}