package com.example.jiangjr.basic.dialog;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jiangjr.basic.R;

/**
 * Created by Jiangjr on 2015/10/20.
 */
public class CustomListAdapter extends ArrayAdapter<String> {
    private int mRes;
    private String[] mItems;
    private TextView mItemView;

    CustomListAdapter(Context _context, int _res, String[] _items){
        super(_context, _res, _items);
        this.mRes = _res;
        this.mItems = _items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        // Inflate a view if none present.
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(mRes, null);
        }

        // Reference the text view from layout.
        mItemView = (TextView) v.findViewById(R.id.item_dialog_list_item);

        // Apply properties.
        mItemView.setText(mItems[position]);
        mItemView.setTextSize(TypedValue.COMPLEX_UNIT_SP, CustomListDialog.mItemTextSize);
        mItemView.setGravity(CustomListDialog.getGravityFromAlignment(CustomListDialog.mItemAlignment) | Gravity.CENTER_VERTICAL);
        mItemView.setTypeface(CustomListDialog.mTypeface);

        try {
            mItemView.setTextColor(CustomListDialog.mItemColour);
        } catch(Exception e){}

        return v;
    }

}
