package com.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_row_item, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textViewName = convertView.findViewById(R.id.textViewName);
            viewHolder.textViewAge = convertView.findViewById(R.id.textViewAge);
            convertView.setTag(viewHolder);
        }

        User user = getItem(position);
        ViewHolder viewHolder = (ViewHolder)convertView.getTag();

        viewHolder.textViewName.setText(user.name);
        viewHolder.textViewAge.setText(user.age + " Years Old");

        return convertView;
    }

    private static class ViewHolder {
        TextView textViewName;
        TextView textViewAge;
    }
}