package com.example.admin.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 11/12/2017.
 */

public class SecondDownAdapter extends RecyclerView.Adapter<SecondDownAdapter.ViewHolder> {

    ArrayList<SecRecDownprovider> arrayList2=new ArrayList<>();
    View view;

    public SecondDownAdapter(ArrayList<SecRecDownprovider> arrayList2) {
        this.arrayList2 = arrayList2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recsecdown_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SecRecDownprovider secRecDownprovider=arrayList2.get(position);
        holder.image.setImageResource(secRecDownprovider.getImg_res());
        holder.tex.setText(secRecDownprovider.getDl_name());

    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tex,tvpf,tvsa;

        public ViewHolder(View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.imager2);
            tex=itemView.findViewById(R.id.textc2);

            tvpf=itemView.findViewById(R.id.tvpartyfun);
            tvsa=itemView.findViewById(R.id.tvvvseeall);

        }

    }

}
