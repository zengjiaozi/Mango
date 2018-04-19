package com.richinfo.www.mylibrary.loader;


import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.richinfo.www.mylibrary.R;
import com.richinfo.www.mylibrary.utils.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * @author
 * @time 2018/4/16  10:58
 * @desc ${TODD}
 */
public class MangoLoader {

    //    加载框宽高比
    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;

    //     默认的加载类型
    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();
    private static final ArrayList<AppCompatDialog> LOADS = new ArrayList<>();

    //    创建加载显示框
    public static void showLoading(Context context, String loader_style) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        AVLoadingIndicatorView indicatorView = LoaderCreator.create(context, loader_style);
        dialog.setContentView(indicatorView);
//        适配屏幕 让弹出框根据屏幕的密度来显示效果
        int screenHeight = DimenUtil.getScreenHeight();
        int screenWidth = DimenUtil.getScreenWidth();

        Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null) {
            WindowManager.LayoutParams layoutParamss = dialogWindow.getAttributes();
            layoutParamss.width = screenWidth / LOADER_SIZE_SCALE;
            layoutParamss.height = screenHeight / LOADER_SIZE_SCALE;
            layoutParamss.height = layoutParamss.height + screenHeight / LOADER_OFFSET_SCALE;
            layoutParamss.gravity = Gravity.CENTER;

        }
        LOADS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context, Enum<LoaderStyle> type) {

        showLoading(context, type.name());

    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }


    public static void stopLoading() {

        for (AppCompatDialog dialog : LOADS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                    dialog.dismiss();
                }
            }


        }

    }


}
