package com.anhttvn.customrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anhttvn.customrecyclerview.adapter.NewAdapter;
import com.anhttvn.customrecyclerview.model.VegetableItem;
import com.anhttvn.customrecyclerview.ui.main.PlaceholderFragment;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class NewHolderFragment extends Fragment {

    RecyclerView recyclerView;
    private NewAdapter mAdapter;
    Context localContext;
    private List<VegetableItem> mList = new ArrayList<>();
//    public static NewHolderFragment newInstance(Context mContext) {
//        NewHolderFragment fragment = new NewHolderFragment();
//        this.localContext = mContext;
//        return fragment;
//    }

    @SuppressLint("ValidFragment")
    public NewHolderFragment(Context mContext){
        super();
        this.localContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_main_2, viewGroup, false);
        recyclerView = itemView.findViewById(R.id.listView);
        addList();
        adapter();
        return itemView;
    }

    private void addList(){
//        mList.clear();
        if(mList.isEmpty()) {
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
    }

    private void adapter(){
        Log.d("anhtt","mlist : " +mList.size());
        mAdapter = new NewAdapter(mList, getContext());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter.notifyDataSetChanged();

    }
}
