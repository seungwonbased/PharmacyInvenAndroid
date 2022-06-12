package com.example.action;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pharmacyinven.R;
import com.example.server.Cart;

import org.w3c.dom.Text;

import java.util.List;

public class BasketAdapter extends BaseAdapter {

    private List<Cart> cart;
    LayoutInflater inflater;

    public BasketAdapter(LayoutInflater inflater, List<Cart> cart) {
        this.cart = cart;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return cart.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return cart.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        if (converView == null) {
            converView = inflater.inflate(R.layout.item_for_basket, null);
        }

        TextView postName = (TextView) converView.findViewById(R.id.textView2);

        postName.setText(cart.get(position).getDrug().getDrugName());

        return converView;
    }

}
