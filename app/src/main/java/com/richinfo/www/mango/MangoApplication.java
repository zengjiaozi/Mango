package com.richinfo.www.mango;

import android.app.Application;

import com.richinfo.www.mylibrary.app.Mango;
import com.richinfo.www.mylibrary.net.interceptors.DebugInterceptor;

/**
 * @author
 * @time 2018/3/27  11:15
 * @desc ${TODD}
 */
public class MangoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Mango.init(this)
                .withApiHost("http://fy.iciba.com/")
                .withLoaderDelayed(1000)
                .withInterceptor(new DebugInterceptor("test", R.raw.test) )
                .configure();

//        http://news.baidu.com/

    }
}
