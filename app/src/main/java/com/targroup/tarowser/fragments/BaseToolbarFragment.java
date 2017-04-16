package com.targroup.tarowser.fragments;

import android.support.v4.app.Fragment;

import com.targroup.tarowser.interfaces.ViewDefineInterface;

/**
 * Created by Rachel on 2017/4/16.
 * Base fragment for all to extend.
 */

public abstract class BaseToolbarFragment extends Fragment {
    public abstract void setInterface (ViewDefineInterface viewDefineInterface);
}
