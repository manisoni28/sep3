package com.anhttvn.customrecyclerview;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity5 extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ArrayList<FruitItem> fruitItemArrayList = new ArrayList<>();
    FloatingActionButton floatingActionButton;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("product");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        recyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.addItem);
//        FruitItem fruitItem = new FruitItem();
//        fruitItem.setImage(R.drawable.bo);
//        fruitItem.setName("Apple");
//        fruitItem.setPrice(100);
//        fruitItem.setWeight(2);
//        fruitItemArrayList.add(fruitItem);
//
//        fruitItem = new FruitItem();
//        fruitItem.setImage(R.drawable.cachua);
//        fruitItem.setName("Orange");
//        fruitItem.setPrice(150);
//        fruitItem.setWeight(1);
//        fruitItemArrayList.add(fruitItem);
//
//        fruitItem = new FruitItem();
//        fruitItem.setImage(R.drawable.cam);
//        fruitItem.setName("Banana");
//        fruitItem.setPrice(50);
//        fruitItem.setWeight(12);
//        fruitItemArrayList.add(fruitItem);
//
//        fruitItem = new FruitItem();
//        fruitItem.setImage(R.drawable.dau);
//        fruitItem.setName("Kiwi");
//        fruitItem.setPrice(300);
//        fruitItem.setWeight(1);
//        fruitItemArrayList.add(fruitItem);

        myAdapter = new MyAdapter(this, fruitItemArrayList);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter.notifyDataSetChanged();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fetchDataByFirebase();

//                FruitItem fruitItem = new FruitItem();
//                fruitItem.setImage(R.drawable.dau);
//                fruitItem.setName("Pineapple");
//                fruitItem.setPrice(200);
//                fruitItem.setWeight(2);
//                fruitItemArrayList.add(fruitItem);
//                myAdapter.notifyDataSetChanged();
            }
        });

    }

    private void fetchGamesByVolley() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://games.atmegame.com/mash/api/gapi/index.php/api/mash";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("Response: ", response.toString());
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Log.i("gname", jsonObject.getString("gname"));
                                FruitItem fruitItem = new FruitItem();
                                fruitItem.setName(jsonObject.getString("gname"));
                                fruitItem.setCategory(jsonObject.getString("category"));
                                fruitItem.setgId(jsonObject.getString("gID"));
                                fruitItem.setgUrl(jsonObject.getString("small_wall"));
                                fruitItem.setWeight(2);
                                fruitItemArrayList.add(fruitItem);
                                myAdapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.i("OnErrorResponse: ", error.toString());

                    }
                });
        queue.add(jsonObjectRequest);
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
                fetchGamesByVolley();
//                String value = dataSnapshot.getValue(String.class);
//                textView.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}