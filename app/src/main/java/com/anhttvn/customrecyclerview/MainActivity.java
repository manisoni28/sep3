package com.anhttvn.customrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.anhttvn.customrecyclerview.adapter.NewAdapter;
import com.anhttvn.customrecyclerview.model.VegetableItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleview;
    private List<VegetableItem> mList = new ArrayList<>();
    private NewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addList();
        adapter();
    }
    private void init(){
        mRecycleview = findViewById(R.id.listView);
    }
    private void addList(){
        VegetableItem vegetableItem = new VegetableItem();
        vegetableItem.setImage(R.drawable.cachua);
        vegetableItem.setName("Tomato");
        vegetableItem.setDescription("Tomato is a good vegetable");
        mList.add(vegetableItem);

        vegetableItem = new VegetableItem();
        vegetableItem.setImage(R.drawable.bo);
        vegetableItem.setName("butter");
        vegetableItem.setDescription("butter is a good vegetable");
        mList.add(vegetableItem);

        vegetableItem = new VegetableItem();
        vegetableItem.setImage(R.drawable.cam);
        vegetableItem.setName("oranges");
        mList.add(vegetableItem);
        vegetableItem.setDescription("oranges is a good vegetable");

        vegetableItem = new VegetableItem();
        vegetableItem.setImage(R.drawable.quaxoai);
        vegetableItem.setName("mango");
        vegetableItem.setDescription("mango is a good vegetable");
        mList.add(vegetableItem);

//        vegetableItem = new VegetableItem();
//        vegetableItem.setImage(R.drawable.dau);
//        vegetableItem.setName("strawberry");
//
//        mList.add(vegetableItem);
//        vegetableItem = new VegetableItem();
//        vegetableItem.setImage(R.drawable.tao);
//        vegetableItem.setName("Apple");
//        mList.add(vegetableItem);
//
//        mList.add(vegetableItem);
//        vegetableItem = new VegetableItem();
//        vegetableItem.setImage(R.drawable.oi);
//        vegetableItem.setName("guava fruit");
//        mList.add(vegetableItem);
    }

    private void adapter(){
        Log.d("anhtt","mlist : " +mList.size());
        mAdapter = new NewAdapter(mList, this);
        mRecycleview.setAdapter(mAdapter);
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.notifyDataSetChanged();

    }
}
