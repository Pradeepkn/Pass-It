package com.passit.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.passit.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getBaseLayout());

        Toolbar toolbar = (Toolbar) findViewById(R.id.base_toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public abstract int getBaseLayout();
}
