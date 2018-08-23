package com.mjd.month_test.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mjd.month_test.R;

/**
 * Created by admin on 2018-8-23.
 */

public class GoodsHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView goods_simple;
    public TextView goods_title,goods_price;

    public GoodsHolder(View itemView) {
        super(itemView);
        goods_simple = itemView.findViewById(R.id.goods_simple);
        goods_title = itemView.findViewById(R.id.goods_title);
        goods_price = itemView.findViewById(R.id.goods_price);

    }
}
