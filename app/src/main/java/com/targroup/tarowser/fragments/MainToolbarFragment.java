package com.targroup.tarowser.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.EditText;

import android.support.annotation.Nullable;
import android.support.transition.Scene;
import android.support.transition.Transition;
import android.support.transition.ChangeBounds;
import android.support.transition.TransitionManager;

import com.targroup.tarowser.R;

/**
 * Created by Rachel on 2017/4/15.
 * Main Toolbar
 */

public class MainToolbarFragment extends BaseToolbarFragment {
    EditText search;

    View toolbarLayout;
    Scene searchScene;
    Transition searchTransition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        toolbarLayout = inflater.inflate(R.layout.toolbar_main, container, false);

        searchScene = Scene.getSceneForLayout(container, R.layout.toolbar_search, getActivity());
        searchTransition = new ChangeBounds().setDuration(150);

        return toolbarLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        search = (EditText) toolbarLayout.findViewById(R.id.toolbar_search);
        getInterface().onViewDefined(search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(searchScene,searchTransition);
                android.util.Log.e("ONCLICK","here we get in Fragment");
            }
        });
    }
}
