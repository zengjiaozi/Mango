package com.richinfo.www.mylibrary.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * @author
 * @time 2018/3/27  14:42
 * @desc ${TODD}
 */
public abstract class BaseDelegate extends SwipeBackFragment {

    private final SupportFragmentDelegate fragmentDelegate = new SupportFragmentDelegate(this);
    protected FragmentActivity _mActivity = null;

    private Unbinder unbinder = null;
    private View rootView = null;

    public abstract Object setLayout();

    public abstract void onBinderView(@Nullable Bundle savedInstanceState, View view);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((int) setLayout(), container, false);
        } else if (rootView instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }
//        绑定控件
        if (rootView != null) {
            unbinder = ButterKnife.bind(this, rootView);
            onBinderView(savedInstanceState, rootView);
        }
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (rootView != null) {
            unbinder.unbind();
        }
    }
}
