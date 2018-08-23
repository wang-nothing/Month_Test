package com.mjd.month_test.presenter;

import com.mjd.month_test.bean.GoodsBean;
import com.mjd.month_test.model.Goods_Model;
import com.mjd.month_test.model.Imodel_goods;
import com.mjd.month_test.view.Iview_goods;

/**
 * Created by admin on 2018-8-23.
 */

public class Goods_Presenter implements Ipresenter_goods {
    private Iview_goods mIview_goods;
    private Goods_Model mGoods_model;

    public Goods_Presenter(Iview_goods iview_goods) {
        mIview_goods = iview_goods;
        mGoods_model = new Goods_Model();
    }

    public void getgss(String pscid){
        mGoods_model.getgs(pscid, new Imodel_goods() {
            @Override
            public void GoodsSuccess(GoodsBean goodsBean) {
                mIview_goods.vGoodsSuccess(goodsBean);
            }
        });
    }

    @Override
    public void Destroys() {
        if (mIview_goods != null){
            mIview_goods = null;
        }
    }
}
