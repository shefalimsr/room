package com.example.payone.room.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.payone.room.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LeadAdapter extends RecyclerView.Adapter<LeadAdapter.LViewHolder> {

    List<SingleData> dataList = new ArrayList<SingleData>();




    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class LViewHolder extends RecyclerView.ViewHolder implements  RowView
    {

        TextView nam, num;


        public LViewHolder(View itemView) {
            super(itemView);
            nam = (TextView) itemView.findViewById(R.id.nam);
            num = (TextView) itemView.findViewById(R.id.num);


        }

        @Override
        public void setName(String title) {
            nam.setText(title);
        }

        @Override
        public void setNumber(String numb) {

            num.setText(numb);

        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public LeadAdapter(List<SingleData> myDataset) {

        dataList=myDataset;

        }


    @Override
    public LViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
        final LViewHolder mViewHolder = new LViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LViewHolder holder, int position) {
        holder.nam.setText(dataList.get(position).getName());
        holder.num.setText(dataList.get(position).getMobile());

    }
        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

