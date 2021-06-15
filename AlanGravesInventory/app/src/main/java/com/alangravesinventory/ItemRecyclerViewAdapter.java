package com.alangravesinventory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ItemViewHolder> {
    ArrayList<Item> items;

    public ItemRecyclerViewAdapter(ArrayList<Item> data) {
        this.items = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_row, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = items.get(position);
        holder.textViewName.setText(item.name);
        holder.textViewAge.setText(item.count + "");
        holder.position = position;
        holder.item = item;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewAge;
        // not needed right now, maybe used to change background color
        View rootView;
        int position;
        Item item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            rootView = itemView;
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAge = itemView.findViewById(R.id.textViewCount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("clicky", "onClick: item clicked " + position + " item " + item.name);
                }
            });
        }
    }
}
