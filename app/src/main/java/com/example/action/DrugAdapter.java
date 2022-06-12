package com.example.action;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pharmacyinven.R;
import com.example.server.Drug;

import java.util.List;

public class DrugAdapter extends BaseAdapter {
    private List<Drug> drug;
    LayoutInflater inflater;

    public DrugAdapter(LayoutInflater inflater, List<Drug> drug) {
        this.drug = drug;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return drug.size();
    }

    @Override
    public Object getItem(int position) {
        return drug.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_for_drug, null);
        }
        TextView postName = (TextView) convertView.findViewById(R.id.textView2);

        postName.setText(drug.get(position).getDrugName());

        return convertView;
    }
}
