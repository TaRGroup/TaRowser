package com.targroup.tarowser.activities;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.content.Context;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.CoordinatorLayout;

import com.targroup.tarowser.R;
import com.targroup.tarowser.fragments.MainContentFragment;
import com.targroup.tarowser.fragments.MainToolbarFragment;
import com.targroup.tarowser.fragments.SearchToolbarFragment;
import com.targroup.tarowser.interfaces.ViewDefineInterface;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout root;
    FrameLayout container;
    Toolbar toolbar;

    MainToolbarFragment mainToolbarFragment;
    SearchToolbarFragment searchToolbarFragment;

    FragmentManager fragmentManager;

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
        mainToolbarFragment.setInterface(new ViewDefineListener());
        searchToolbarFragment = new SearchToolbarFragment();
        searchToolbarFragment.setInterface(new ViewDefineListener());

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.fragment_container,new MainContentFragment()).add(R.id.toolbar, mainToolbarFragment).commit();
    }

    public class ViewDefineListener implements ViewDefineInterface {
        @Override
        public void onViewDefined(View v) {
            android.util.Log.e("ONCLICK", "get passed view " + v.getId() + " and search is " + R.id.toolbar_search);
            // TODO: switch 有问题
            switch (v.getId()) {
                case R.id.toolbar_search:
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            android.util.Log.e("ONCLICK","here we get in Activity");
                            fragmentManager.beginTransaction().replace(R.id.toolbar, searchToolbarFragment).addToBackStack(null).commit();
                            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_IMPLICIT_ONLY);
                        }
                    });
                    break;
                case R.id.toolbar_dismiss:
                    v.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            fragmentManager.beginTransaction().replace(R.id.toolbar, mainToolbarFragment).commit();
                        }
                    });
                    break;
            }
        }
    }
}
