package com.richinfo.www.mylibrary.activities;

import android.support.v7.app.AppCompatActivity;

import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportActivity;
import me.yokeyword.fragmentation.SupportActivityDelegate;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * @author
 * @time 2018/3/27  14:33
 * @desc ${TODD}
 */
public class BaseActivity extends AppCompatActivity implements ISupportActivity {

    private  final  SupportActivityDelegate  delegate = new SupportActivityDelegate(this);


    @Override
    public SupportActivityDelegate getSupportDelegate() {
        return null;
    }

    @Override
    public ExtraTransaction extraTransaction() {
        return null;
    }

    @Override
    public FragmentAnimator getFragmentAnimator() {
        return null;
    }

    @Override
    public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return null;
    }

    @Override
    public void onBackPressedSupport() {

    }
}
