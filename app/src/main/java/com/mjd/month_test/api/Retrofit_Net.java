package com.mjd.month_test.api;

import com.mjd.month_test.bean.BannerBean;
import com.mjd.month_test.bean.GoodsBean;
import com.mjd.month_test.bean.ListBean;
import com.mjd.month_test.bean.UserBean;
import com.youth.banner.Banner;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by admin on 2018-8-23.
 */

public interface Retrofit_Net {

    //轮播https://www.zhaoapi.cn/quarter/getAd
    @POST("quarter/getAd")
    Observable<BannerBean> getbanner();

    //设计师https://app.tuozhe8.com/api.php/api/Lists/designer?token=&version=1.7
    @POST("api.php/api/Lists/designer")
    Observable<UserBean> getuser(@Query("token") String token, @Query("version") String version);

    //列表https://www.zhaoapi.cn/product/getCatagory
    @POST("product/getCatagory")
    Observable<ListBean> getlist();

    //商品列表https://www.zhaoapi.cn/product/getProducts?pscid=1
    @POST("product/getProducts")
    Observable<GoodsBean> getgood(@Query("pscid") String pscid);
}
