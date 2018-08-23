package com.mjd.month_test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mjd.month_test.R;
import com.mjd.month_test.bean.UserBean;
import com.mjd.month_test.holder.UserHolder;

import java.util.List;

/**
 * Created by admin on 2018-8-23.
 */

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {
    private Context mContext;
    private List<UserBean.DataBean.DisplayBean> display;
    private View mView;

    public UserAdapter(Context context, List<UserBean.DataBean.DisplayBean> display) {
        mContext = context;
        this.display = display;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.item_user, null);
        return new UserHolder(mView);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.user_simple.setImageURI(display.get(position).getAvatar());
        holder.user_name.setText(display.get(position).getNick_name());
    }

    @Override
    public int getItemCount() {
        return display.size();
    }
}
