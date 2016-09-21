package com.example.tech_2.intentcontrolling;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tech-2 on 21/9/16.
 */
public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.MyViewHolder> {
    private final List<ListingModel> allList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textVal;
        public Button deleteBtn;

        public MyViewHolder(View view) {
            super(view);
            textVal = (TextView) view.findViewById(R.id.textVal);
            deleteBtn = (Button) view.findViewById(R.id.deleteButton);
        }
    }

    public ListingAdapter(List<ListingModel> allList) {
        this.allList = allList;
    }

    public List<ListingModel>  getAllList(){
        return this.allList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_listing_text, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ListingModel movie = allList.get(position);
        holder.textVal.setText(movie.getValue());
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                allList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return allList.size();
    }

}

