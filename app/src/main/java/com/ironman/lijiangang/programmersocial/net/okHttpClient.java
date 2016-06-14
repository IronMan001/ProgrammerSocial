package com.ironman.lijiangang.programmersocial.net;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by lijiangang on 16/6/14.
 */
public class okHttpClient {


    /**
     * GET
     * @param url
     */
    public static void OkHttp_GET(String url){
        url = "http://www.csdn.net/";

        OkHttpUtils
                .get()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call request, Exception e,int i)
                    {

                    }

                    @Override
                    public void onResponse(String response,int i)
                    {

                    }
                });
    }


    /**
     * POST
     * @param url
     */
    public static void OkHttp_POST(String url){
        OkHttpUtils
                .post()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {

                    }
                });
    }


    /**
     * 将一个实体类转换成JSON字符串发送给服务器
     * @param url
     */
    public static void OkHttp_JSON_POST(String url){

        OkHttpUtils
                .postString()
                .url(url)
//                .content(new Gson().toJson(new User("zhy", "123")))   //这里少个实体类
                .build()
//                .execute(new myStringCallback())
                ;
    }

    /**
     * 将文件作为请求体，发送到服务器。
     * @param url
     * @param file
     */
    public static void OkHttp_File_POST(String url,File file){
        OkHttpUtils
                .postFile()
                .url(url)
                .file(file)
                .build()
//                .execute(new MyStringCallback())
        ;
    }

    /**
     * Post表单形式上传文件
     * 支持单个多个文件，addFile的第一个参数为文件的key，即类别表单中<input type="file" name="mFile"/>的name属性。
     * @param file
     * @param file2
     * @param url
     * @param params
     * @param headers
     */
    public static void OkHttp_File_Form_POST(File file, File file2, String url, Map<String, String> params,Map<String, String> headers){
        OkHttpUtils.post()//
                .addFile("mFile", "messenger_01.png", file)//
                .addFile("mFile", "test1.txt", file2)//
                .url(url)
                .params(params)//
                .headers(headers)//
                .build()//
//                .execute(new MyStringCallback())
        ;
    }



    //更多用法
    //https://github.com/hongyangAndroid/okhttp-utils

}
