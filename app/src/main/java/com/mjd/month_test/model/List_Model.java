package com.mjd.month_test.model;

import com.mjd.month_test.api.RetrofitClient;
import com.mjd.month_test.bean.ListBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2018-8-23.
 */

public class List_Model {
    public void getls(final Imodel_list imodel_list){
        RetrofitClient.getInstance().getCommonApi().getlist().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ListBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ListBean listBean) {
                imodel_list.ListSuccess(listBean);
            }
        });
    }
}
