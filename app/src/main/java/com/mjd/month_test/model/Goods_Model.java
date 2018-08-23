package com.mjd.month_test.model;

import com.mjd.month_test.api.RetrofitClient;
import com.mjd.month_test.bean.GoodsBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2018-8-23.
 */

public class Goods_Model {
    public void getgs(String pscid, final Imodel_goods imodel_goods){
        RetrofitClient.getInstance().getCommonApi().getgood(pscid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<GoodsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(GoodsBean goodsBean) {
                imodel_goods.GoodsSuccess(goodsBean);
            }
        });
    }
}
