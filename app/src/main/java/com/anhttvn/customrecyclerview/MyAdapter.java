package com.anhttvn.customrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context localContext;
    private ArrayList<FruitItem> localList;

    public MyAdapter(Context context, ArrayList<FruitItem> fruitItemArrayList) {
        this.localContext = context;
        this.localList = fruitItemArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(localContext).inflate(R.layout.fruit_item, viewGroup, false);
        return new FruitViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        FruitViewHolder localViewHolder = (FruitViewHolder) viewHolder;
        localViewHolder.fruitName.setText(localList.get(position).getName());
        localViewHolder.fruitWeight.setText(String.valueOf(localList.get(position).getgId()));
        localViewHolder.fruitPrice.setText(String.valueOf(localList.get(position).getCategory()));
//        localViewHolder.fruitImage.setImageResource(localList.get(position).getImage());
        Glide.with(localContext)
                .load(localList.get(position).getgUrl())
                .centerCrop()
                .into(localViewHolder.fruitImage);
        localViewHolder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(localContext, MainActivity6.class);
                intent.putExtra("image", localList.get(position).getImage());
                intent.putExtra("price", localList.get(position).getPrice());
                localContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localList.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName, fruitWeight, fruitPrice;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitImage = itemView.findViewById(R.id.fruitImage);
            fruitName = itemView.findViewById(R.id.fruitName);
            fruitPrice = itemView.findViewById(R.id.fruitPrice);
            fruitWeight = itemView.findViewById(R.id.fruitWeight);
        }
    }
}
