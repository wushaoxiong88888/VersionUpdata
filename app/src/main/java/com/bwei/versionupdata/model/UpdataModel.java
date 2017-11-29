package com.bwei.versionupdata.model;

import com.bwei.versionupdata.api.API;
import com.bwei.versionupdata.apiservice.ApiService;
import com.bwei.versionupdata.bean.UpdataBean;
import com.bwei.versionupdata.utils.OnNetListener;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pc on 2017/11/29.
 */

public class UpdataModel {
    public void getUpdata(int type, final OnNetListener onNetListener) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(API.URL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<UpdataBean> observable = apiService.updata(type);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpdataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(UpdataBean updataBean) {
                        onNetListener.onSuccess(updataBean);
                    }
                });

    }
}
