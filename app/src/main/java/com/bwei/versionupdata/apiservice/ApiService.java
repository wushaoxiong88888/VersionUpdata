package com.bwei.versionupdata.apiservice;

import com.bwei.versionupdata.bean.UpdataBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pc on 2017/11/29.
 */

public interface ApiService {

    /**
     * https://www.zhaoapi.cn/
     * version/getVersion
     * ?type=0
     *
     */
    @GET("version/getVersion")
    Observable<UpdataBean> updata(@Query("type")int type);

}
