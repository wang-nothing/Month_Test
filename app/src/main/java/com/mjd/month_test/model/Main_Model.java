package com.mjd.month_test.model;

import android.util.Log;

import com.mjd.month_test.api.RetrofitClient;
import com.mjd.month_test.api.RetrofitClient2;
import com.mjd.month_test.bean.BannerBean;
import com.mjd.month_test.bean.ListBean;
import com.mjd.month_test.bean.UserBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2018-8-23.
 */

public class Main_Model {
    public void getBans(final Imodel_main imodel_main){
        RetrofitClient.getInstance().getCommonApi().getbanner().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BannerBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BannerBean bannerBean) {
                imodel_main.BannerSuccess(bannerBean);
                Log.i("TAG", "onNext: ");
            }
        });
    }
}
