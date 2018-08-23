package com.mjd.month_test.presenter;

import com.mjd.month_test.bean.ListBean;
import com.mjd.month_test.model.Imodel_list;
import com.mjd.month_test.model.List_Model;
import com.mjd.month_test.view.Iview_list;

/**
 * Created by admin on 2018-8-23.
 */

public class List_Presenter implements Ipresenter_list {
    private Iview_list mIview_list;
    private List_Model mList_model;

    public List_Presenter(Iview_list iview_list) {
        mIview_list = iview_list;
        mList_model = new List_Model();
    }

    public void getlss(){
        mList_model.getls(new Imodel_list() {
            @Override
            public void ListSuccess(ListBean listBean) {
                mIview_list.vListSuccess(listBean);
            }
        });
    }

    @Override
    public void Destroys() {
        if (mIview_list != null){
            mIview_list = null;
        }
    }
}
