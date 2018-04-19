package com.richinfo.www.mylibrary.app;

import android.os.Handler;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * @author
 * @time 2018/3/27  10:19
 * @desc 不需要外不去更改 单例模式
 */
public final class Configurator {


    private static HashMap<Object, Object> MANGO_CONFIGS = new HashMap<>();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    private static final Handler HANDLER = new Handler();


    //    创建全局的初始化变量的标志
    private Configurator() {
        MANGO_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
        MANGO_CONFIGS.put(ConfigKeys.HANDLE, HANDLER);

    }

    public final Configurator withApiHost(String host) {
        MANGO_CONFIGS.put(ConfigKeys.API_HOST, host);
        return this;
    }

    public void configure() {
//        initIcons();
        MANGO_CONFIGS.put(ConfigKeys.CONFIG_READY, true);

    }
    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        MANGO_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }


    public static final HashMap<Object, Object> getMangoConfigs() {
        return MANGO_CONFIGS;
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public Configurator withLoaderDelayed(long i) {
        MANGO_CONFIGS.put(ConfigKeys.LOADER_DELAYED, i);
        return this;

    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();

    }

    //    检查是否加载配置我完成
    private void checkConfiguration() {
        final boolean isReady = (boolean) MANGO_CONFIGS.get(ConfigKeys.CONFIG_READY);
//        没有初始化完成后 抛出异常
        if (!isReady) {
            throw new RuntimeException("configuration is not ready , call configurator");
        }
    }

    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        Object value = MANGO_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(value.toString() + "is null");
        }
        return (T) MANGO_CONFIGS.get(key);


    }


}
