package com.mjd.month_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjd.month_test.R;
import com.mjd.month_test.bean.ListBean;
import com.mjd.month_test.bean.UserBean;
import com.mjd.month_test.holder.ListHolder;
import com.mjd.month_test.holder.UserHolder;

import java.util.List;

/**
 * Created by admin on 2018-8-23.
 */

public class ListAdapter extends RecyclerView.Adapter<ListHolder> {
    private Context mContext;
    private List<ListBean.DataBean> data;
    private View mView;

    public ListAdapter(Context context, List<ListBean.DataBean> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
        return new ListHolder(mView);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.list_simple.setImageURI(data.get(position).getIcon());
        holder.list_time.setText(data.get(position).getCreatetime());
        holder.list_name.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
