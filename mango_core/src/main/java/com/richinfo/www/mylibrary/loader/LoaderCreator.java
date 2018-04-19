package com.richinfo.www.mylibrary.loader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

import java.util.WeakHashMap;

/**
 * @author
 * @time 2018/4/16  14:14
 * @desc ${TODD}
 */
public class LoaderCreator {

    private static final WeakHashMap<String, Indicator> LOADING_MAP = new WeakHashMap<>();

    static final AVLoadingIndicatorView create(Context context, String type) {
//          创建一个laod对象
        final AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);
        if (LOADING_MAP.get(type) == null) {
            Indicator indicator = getIndicator(type);
            LOADING_MAP.put(type, indicator);

        }
        avLoadingIndicatorView.setIndicator(LOADING_MAP.get(type));
        return avLoadingIndicatorView;


    }

    private static Indicator getIndicator(String type) {
        if (TextUtils.isEmpty(type)) {
            return null;
        }
        final StringBuilder stringBuilder = new StringBuilder();
        if (!type.contains(".")) {
            final String defaultPackagename = AVLoadingIndicatorView.class.getPackage().getName();
            stringBuilder.append(defaultPackagename).append(".indicators").append(".");
            Log.i("TAG", "string builder " + stringBuilder.toString());
        }
        stringBuilder.append(type);
        try {
            Class<?> aClass = Class.forName(stringBuilder.toString());
            return (Indicator) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
