package com.mky1428.owncook1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RecItem> items;

    public RecAdapter(Context context, ArrayList<RecItem> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.recycler_item_rec, parent, false);

        VH holder = new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VH vh = (VH) holder;

        RecItem recItem = items.get(position);

        vh.tvType.setText(recItem.type);

        Glide.with(context).load(recItem.img).into(vh.ivType);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView ivType;
        TextView tvType;

        public VH(@NonNull  View itemView) {
            super(itemView);

            ivType = itemView.findViewById(R.id.iv_type);
            tvType = itemView.findViewById(R.id.tv_type);

        }
    }

}































