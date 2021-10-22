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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {

    Context context;
    ArrayList<RecyclerItem> items;

    public MyAdapter(Context context, ArrayList<RecyclerItem> items) {
        this.context = context;
        this.items = items;
    }

    public VH onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_parse_recipe2, parent, false);
        VH vh = new VH(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull VH holder, int position) {
        RecyclerItem item = items.get(position);

        Glide.with(context).load(item.ATT_FILE_NO_MAIN).into(holder.img);
        holder.tv_RCP_NM.setText(item.RCP_NM);
        holder.tv_RCP_PARTS_DTLS.setText(item.RCP_PARTS_DTLS);
        holder.tv_MANUAL.setText(item.MANUAL);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tv_RCP_NM;
        TextView tv_RCP_PARTS_DTLS;
        TextView tv_MANUAL;

        public VH(@NonNull @NotNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv);
            tv_RCP_NM = itemView.findViewById(R.id.tv_name);
            tv_RCP_PARTS_DTLS = itemView.findViewById(R.id.tv_ingredient);
            tv_MANUAL = itemView.findViewById(R.id.tv_manual);
        }
    }

}
