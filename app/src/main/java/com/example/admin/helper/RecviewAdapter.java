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

public class RecviewAdapter extends RecyclerView.Adapter<RecviewAdapter.ViewHolder> {

    private ArrayList<DataProvider> arrayList=new ArrayList<>();
    View view;

    public RecviewAdapter(ArrayList<DataProvider> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecviewAdapter.ViewHolder holder, int position) {

        DataProvider dataProvider=arrayList.get(position);
        holder.imageView.setImageResource(dataProvider.getImg_res());
        holder.txtv.setText(dataProvider.getS_name());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtv,tvrps,tvseeall;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.imager1);
            txtv=(TextView)itemView.findViewById(R.id.textc);

            tvrps=itemView.findViewById(R.id.tvrepairservices);
            tvseeall=itemView.findViewById(R.id.tseeall);

        }

    }

}
