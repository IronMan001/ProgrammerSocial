package com.ironman.lijiangang.programmersocial;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by lijiangang on 16/6/14.
 */
public class MyApplication extends Application {




    private OkHttpUtils  initOkHttp(){
        //支持Cookie
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));



        //设置可访问所有的https网站
//        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);

        //设置具体的证书
//        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(证书的inputstream, null, null);

        //双向认证
//        HttpsUtils.getSslSocketFactory(证书的inputstream, 本地证书的inputstream, 本地证书的密码);



        OkHttpClient okHttpClient= new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))  //log拦截器
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)

                //其他配置
                .cookieJar(cookieJar)    //支持Cookie
//                .sslSocketFactory(sslParams.sSLSocketFactory,sslParams.trustManager)  //支持访问https的网站

                .build();

        return OkHttpUtils.initClient(okHttpClient);
    }


    @Override
    public void onCreate() {
        super.onCreate();

        initOkHttp();
    }
}
