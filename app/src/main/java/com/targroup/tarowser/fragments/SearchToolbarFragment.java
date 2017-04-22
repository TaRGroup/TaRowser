package com.targroup.tarowser.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import android.support.annotation.Nullable;
import android.support.transition.ChangeBounds;
import android.support.transition.Scene;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;

import com.targroup.tarowser.R;

/**
 * Created by Rachel on 2017/4/16.
 * Searching fragment, in main Toolbar
 */

public class SearchToolbarFragment extends BaseToolbarFragment {
    EditText search;
    ImageButton dismiss;

    View searchLayout;
    Scene mainScene;
    Transition mainTransition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        searchLayout = inflater.inflate(R.layout.toolbar_search, container, false);

        mainScene = Scene.getSceneForLayout(container, R.layout.toolbar_main, getActivity());
        mainTransition = new ChangeBounds().setDuration(150);

        return searchLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        search = (EditText) searchLayout.findViewById(R.id.toolbar_search);
        search.requestFocus();

        dismiss = (ImageButton) searchLayout.findViewById(R.id.toolbar_dismiss);
        getInterface().onViewDefined(dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.go(mainScene, mainTransition);
            }
        });
    }
}
