package com.mjd.month_test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mjd.month_test.R;
import com.mjd.month_test.adapter.GoodsAdapter;
import com.mjd.month_test.bean.GoodsBean;
import com.mjd.month_test.presenter.Goods_Presenter;
import com.mjd.month_test.view.Iview_goods;

import java.util.List;

public class ShowActivity extends AppCompatActivity implements Iview_goods {


    private RecyclerView show_recyclerview;
    private String pscid = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initViews();
        initDatas();
    }

    private void initDatas() {
        Goods_Presenter goods_presenter = new Goods_Presenter(this);
        goods_presenter.getgss(pscid);
    }

    private void initViews() {
        show_recyclerview = findViewById(R.id.show_recyclerview);
        show_recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void vGoodsSuccess(GoodsBean goodsBean) {
        List<GoodsBean.DataBean> data = goodsBean.getData();
        GoodsAdapter goodsAdapter = new GoodsAdapter(ShowActivity.this, data);
        show_recyclerview.setAdapter(goodsAdapter);
    }
}
