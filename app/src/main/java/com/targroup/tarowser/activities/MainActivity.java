package com.targroup.tarowser.activities;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.content.Context;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.CoordinatorLayout;

import com.targroup.tarowser.R;
import com.targroup.tarowser.fragments.MainContentFragment;
import com.targroup.tarowser.fragments.MainToolbarFragment;
import com.targroup.tarowser.fragments.SearchToolbarFragment;
import com.targroup.tarowser.interfaces.ViewDefineInterface;

public class MainActivity extends AppCompatActivity implements ViewDefineInterface{
    CoordinatorLayout root;
    FrameLayout container;
    Toolbar toolbar;

    MainToolbarFragment mainToolbarFragment;
    SearchToolbarFragment searchToolbarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        root = (CoordinatorLayout) findViewById(R.id.root);
        container = (FrameLayout) findViewById(R.id.fragment_container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        mainToolbarFragment = new MainToolbarFragment();
        mainToolbarFragment.setInterface(this);
        searchToolbarFragment = new SearchToolbarFragment();
        searchToolbarFragment.setInterface(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainContentFragment()).replace(R.id.toolbar,mainToolbarFragment).commitAllowingStateLoss();
    }

    @Override
    public void onViewDefined(View v) {
        switch (v.getId()) {
            case R.id.toolbar_search:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.toolbar, searchToolbarFragment).commit();
                        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
                        // TODO:给！我！ Show！ keyboard！ 在这里也好 在 SearchToolbarFragment 也好
                    }
                });
                break;
            case R.id.toolbar_dismiss:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.toolbar, mainToolbarFragment).commit();
                    }
                });
                break;
        }
    }
}
