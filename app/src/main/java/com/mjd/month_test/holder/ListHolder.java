package com.mjd.month_test.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mjd.month_test.R;

/**
 * Created by admin on 2018-8-23.
 */

public class ListHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView list_simple;
    public TextView list_time,list_name;

    public ListHolder(View itemView) {
        super(itemView);
        list_simple = itemView.findViewById(R.id.list_simple);
        list_time = itemView.findViewById(R.id.list_time);
        list_name = itemView.findViewById(R.id.list_name);

    }
}
