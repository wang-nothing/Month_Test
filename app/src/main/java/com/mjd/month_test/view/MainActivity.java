package com.mjd.month_test.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mjd.month_test.R;
import com.mjd.month_test.activity.ShowActivity;
import com.mjd.month_test.activity.WebActivity;
import com.mjd.month_test.adapter.ListAdapter;
import com.mjd.month_test.adapter.UserAdapter;
import com.mjd.month_test.bean.BannerBean;
import com.mjd.month_test.bean.ListBean;
import com.mjd.month_test.bean.UserBean;
import com.mjd.month_test.presenter.List_Presenter;
import com.mjd.month_test.presenter.Main_Presenter;
import com.mjd.month_test.presenter.User_Presenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview_main, Iview_user, Iview_list {
    private Banner main_bannere;
    private RecyclerView hor_recyclerview,ver_recyclerview;
    private List<String> mImages;
    private String token = "";
    private String version = "1.7";
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initDatas();
    }

    private void initDatas() {
        Main_Presenter main_presenter = new Main_Presenter(this);
        main_presenter.getBanss();

        User_Presenter user_presenter = new User_Presenter(this);
        user_presenter.getuss(token, version);

        List_Presenter list_presenter = new List_Presenter(this);
        list_presenter.getlss();
    }

    private void initViews() {
        main_bannere = findViewById(R.id.main_bannere);
        hor_recyclerview = findViewById(R.id.hor_recyclerview);
        ver_recyclerview = findViewById(R.id.ver_recyclerview);
        textView3 = findViewById(R.id.textView3);
        hor_recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ver_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowActivity.class));
            }
        });
    }

    @Override
    public void vBannerSuccess(BannerBean bannerBean) {
        final List<BannerBean.DataBean> data = bannerBean.getData();
        String icon1 = data.get(0).getIcon();
        String icon2 = data.get(1).getIcon();
        String icon3 = data.get(2).getIcon();
        String icon4 = data.get(3).getIcon();
        mImages = new ArrayList<>();
        mImages.add(icon1);
        mImages.add(icon2);
        mImages.add(icon3);
        mImages.add(icon4);
        main_bannere.setImageLoader(new MyLoader());
        main_bannere.setImages(mImages);
        //设置轮播图的标题集合
//        main_bannere.setBannerTitles(mText);
        main_bannere.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        main_bannere.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        main_bannere.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Log.i("tag", "你点了第"+position+"张轮播图");
                    }
                })
                //必须最后调用的方法，启动轮播图。
                .start();
        main_bannere.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("banner", data.get(position).getUrl());
                startActivity(intent);
            }
        });
    }

    @Override
    public void vUserSuccess(UserBean userBean) {
        List<UserBean.DataBean.DisplayBean> display = userBean.getData().getDisplay();
        UserAdapter userAdapter = new UserAdapter(MainActivity.this, display);
        hor_recyclerview.setAdapter(userAdapter);
    }

    @Override
    public void vListSuccess(ListBean listBean) {
        List<ListBean.DataBean> data = listBean.getData();
        ListAdapter listAdapter = new ListAdapter(this, data);
        ver_recyclerview.setAdapter(listAdapter);
        ver_recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
