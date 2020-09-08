package com.anhttvn.customrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anhttvn.customrecyclerview.adapter.NewAdapter;
import com.anhttvn.customrecyclerview.model.VegetableItem;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class KuchBhiFragment extends Fragment {

    RecyclerView recyclerView;
    private List<VegetableItem> mList = new ArrayList<>();
    private NewAdapter mAdapter;
    private Context localContext;

    @SuppressLint("ValidFragment")
    public KuchBhiFragment(Context mContext) {
        super();
        localContext = mContext;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_2, container, false);
        recyclerView = rootView.findViewById(R.id.listView);
        addList();
        adapter();
        return rootView;
    }


    private void addList() {
        VegetableItem vegetableItem = new VegetableItem();
        vegetableItem.setImage(R.drawable.cachua);
        vegetableItem.setName("Sanjana");
        vegetableItem.setDescription("Tomato is a good vegetable");
        mList.add(vegetableItem);

        vegetableItem = new VegetableItem();
        vegetableItem.setImage(R.drawable.bo);
        vegetableItem.setName("Shubh");
        vegetableItem.setDescription("butter is a good vegetable");
        mList.add(vegetableItem);

        vegetableItem = new VegetableItem();
        vegetableItem.setImage(R.drawable.cam);
        vegetableItem.setName("Rizwan");
        mList.add(vegetableItem);
        vegetableItem.setDescription("oranges is a good vegetable");

        vegetableItem = new VegetableItem();
        vegetableItem.setImage(R.drawable.quaxoai);
        vegetableItem.setName("Safiya");
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

    private void adapter() {
        Log.d("anhtt", "mlist : " + mList.size());
        mAdapter = new NewAdapter(mList, getContext());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter.notifyDataSetChanged();

    }
}
