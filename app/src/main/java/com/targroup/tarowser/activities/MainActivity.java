package com.targroup.tarowser.activities;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.CoordinatorLayout;

import com.targroup.tarowser.R;
import com.targroup.tarowser.fragments.MainContentFragment;
import com.targroup.tarowser.fragments.MainToolbarFragment;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout root;
    FrameLayout container;
    Toolbar toolbar;

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

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainContentFragment()).replace(R.id.toolbar,new MainToolbarFragment()).commitAllowingStateLoss();
    }
}
