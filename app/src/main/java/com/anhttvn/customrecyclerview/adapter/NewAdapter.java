package com.anhttvn.customrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhttvn.customrecyclerview.MainActivity;
import com.anhttvn.customrecyclerview.MainActivity2;
import com.anhttvn.customrecyclerview.R;
import com.anhttvn.customrecyclerview.ScrollingActivity;
import com.anhttvn.customrecyclerview.model.VegetableItem;

import java.util.List;

public class NewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<VegetableItem> localList;
    private Context localContext;


    public NewAdapter(List<VegetableItem> mList, Context context) {
        super();
        localList = mList;
        localContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutInflater = LayoutInflater.from(localContext).inflate(R.layout.item_custom, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(layoutInflater);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final VegetableItem vegetableItem = localList.get(position);
        ViewHolder localViewHolder = (ViewHolder) viewHolder;
        localViewHolder.imageView.setImageResource(vegetableItem.getImage());
        localViewHolder.textView.setText(vegetableItem.getName());
        localViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(localContext, ScrollingActivity.class);
                intent.putExtra("vegetableDescription",vegetableItem.getDescription());
                localContext.startActivity(intent);
            }
        });

        localViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(localContext, MainActivity2.class);
                localContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.img_item);


        }
    }
}
