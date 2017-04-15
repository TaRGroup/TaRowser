package com.targroup.tarowser.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.targroup.tarowser.R;

/**
 * Created by Rachel on 2017/4/15.
 * Main UI
 */

public class MainContentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View main_layout = inflater.inflate(R.layout.content_main, container, false);
        return main_layout;
    }
}
