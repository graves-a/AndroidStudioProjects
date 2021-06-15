package com.alangravesinventory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_row, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textViewName = convertView.findViewById(R.id.textViewName);
            viewHolder.textViewCount = convertView.findViewById(R.id.textViewCount);
            convertView.setTag(viewHolder);
        }

        Item item = getItem(position);
        ViewHolder viewHolder = (ViewHolder)convertView.getTag();

        viewHolder.textViewName.setText(item.name);
        viewHolder.textViewCount.setText(item.count + "");

        return convertView;
    }

    private static class ViewHolder {
        TextView textViewName;
        TextView textViewCount;
    }
}
