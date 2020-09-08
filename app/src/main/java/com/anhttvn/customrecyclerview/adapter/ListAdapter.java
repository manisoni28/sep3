package com.anhttvn.customrecyclerview.adapter;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhttvn.customrecyclerview.R;
import com.anhttvn.customrecyclerview.model.VegetableItem;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<VegetableItem> mList;
    private Context mContext;

    public ListAdapter(List<VegetableItem> list, Context context) {
        super();
        mList = list;
        mContext = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_custom, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        VegetableItem vegetableItem = mList.get(position);
        ((ViewHolder) viewHolder).mTv_name.setText(vegetableItem.getName());
        ((ViewHolder) viewHolder).mImg.setImageResource(vegetableItem.getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTv_name;
        public ImageView mImg;

        public ViewHolder(View shubhView) {
            super(shubhView);
            mTv_name = (TextView) shubhView.findViewById(R.id.tv_name);
            mImg = (ImageView) shubhView.findViewById(R.id.img_item);

        }
    }
}
