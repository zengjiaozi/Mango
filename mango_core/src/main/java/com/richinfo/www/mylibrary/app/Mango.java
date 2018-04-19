package com.richinfo.www.mylibrary.app;

import android.content.Context;
import android.os.Handler;

/**
 * @author
 * @time 2018/3/27  11:02
 * @desc 全局初始化
 */
public final class Mango {


    public static Configurator init(Context context) {
        Configurator.getInstance().getMangoConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();


    }

    public static Configurator getConfigUrator() {
        return Configurator.getInstance();
    }


    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }


    public static <T> T getConfiguration(Object key) {
        return getConfigUrator().getConfiguration(key);
    }

    public static Handler getHandler() {

        return getConfiguration(ConfigKeys.HANDLE);
    }


}
