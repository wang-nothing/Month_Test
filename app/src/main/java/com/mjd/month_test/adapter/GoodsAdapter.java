package com.mjd.month_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjd.month_test.R;
import com.mjd.month_test.bean.GoodsBean;
import com.mjd.month_test.bean.ListBean;
import com.mjd.month_test.holder.GoodsHolder;
import com.mjd.month_test.holder.ListHolder;

import java.util.List;

/**
 * Created by admin on 2018-8-23.
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsHolder> {
    private Context mContext;
    private List<GoodsBean.DataBean> data;
    private View mView;

    public GoodsAdapter(Context context, List<GoodsBean.DataBean> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public GoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_goods, null);
        return new GoodsHolder(mView);
    }

    @Override
    public void onBindViewHolder(GoodsHolder holder, int position) {
        holder.goods_simple.setImageURI(data.get(position).getImages().split("\\|")[0]);
        holder.goods_title.setText(data.get(position).getTitle());
        holder.goods_price.setText(data.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
