package com.mjd.month_test.model;

import com.mjd.month_test.api.RetrofitClient2;
import com.mjd.month_test.bean.UserBean;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2018-8-23.
 */

public class User_Model {
    public void getus(String token, String version, final Imodel_user imodel_user){
        RetrofitClient2.getInstance().getCommonApi().getuser(token, version).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<UserBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserBean userBean) {
                imodel_user.UserSuccess(userBean);
            }
        });
    }
}
