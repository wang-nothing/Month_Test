package com.mjd.month_test.presenter;

import com.mjd.month_test.bean.BannerBean;
import com.mjd.month_test.model.Imodel_main;
import com.mjd.month_test.model.Main_Model;
import com.mjd.month_test.view.Iview_main;

/**
 * Created by admin on 2018-8-23.
 */

public class Main_Presenter implements Ipresenter_main {
    private Iview_main mIview_main;
    private Main_Model mMain_model;

    public Main_Presenter(Iview_main iview_main) {
        mIview_main = iview_main;
        mMain_model = new Main_Model();
    }

    public void getBanss(){
        mMain_model.getBans(new Imodel_main() {
            @Override
            public void BannerSuccess(BannerBean bannerBean) {
                mIview_main.vBannerSuccess(bannerBean);
            }
        });
    }



    @Override
    public void Destroys() {
        if (mIview_main != null){
            mIview_main = null;
        }
    }
}
