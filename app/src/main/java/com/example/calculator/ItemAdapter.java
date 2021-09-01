package com.example.calculator;

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

    private Context context;
    private int resource;
    List<Item> items;

    public ItemAdapter(@NonNull Context context, int resource,List<Item> objects) {
        super(context, resource,objects);
        this.context=context;
        this.items=objects;
        this.resource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(resource,parent,false);
        TextView description=row.findViewById(R.id.description);

        Item item=items.get(position);
        description.setText(item.getDescription());

        return row;

    }
}
