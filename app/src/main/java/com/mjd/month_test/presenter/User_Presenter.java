package com.mjd.month_test.presenter;

import com.mjd.month_test.bean.UserBean;
import com.mjd.month_test.model.Imodel_user;
import com.mjd.month_test.model.User_Model;
import com.mjd.month_test.view.Iview_user;

/**
 * Created by admin on 2018-8-23.
 */

public class User_Presenter implements Ipresenter_user {
    private Iview_user mIview_user;
    private User_Model mUser_model;

    public User_Presenter(Iview_user iview_user) {
        mIview_user = iview_user;
        mUser_model = new User_Model();
    }

    public void getuss(String token, String version){
        mUser_model.getus(token, version, new Imodel_user() {
            @Override
            public void UserSuccess(UserBean userBean) {
                mIview_user.vUserSuccess(userBean);
            }
        });
    }
    @Override
    public void Destroys() {
        if (mIview_user != null){
            mIview_user = null;
        }
    }
}
