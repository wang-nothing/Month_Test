package com.mjd.month_test.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mjd.month_test.R;

/**
 * Created by admin on 2018-8-23.
 */

public class UserHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView user_simple;
    public TextView user_name;

    public UserHolder(View itemView) {
        super(itemView);
        user_simple = itemView.findViewById(R.id.user_simple);
        user_name = itemView.findViewById(R.id.user_name);

    }
}
