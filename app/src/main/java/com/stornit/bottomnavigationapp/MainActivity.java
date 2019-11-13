package com.stornit.bottomnavigationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    // == Fields ==
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mNavigationItemSelectedListener);
        toolbar.setTitle("Shop");
        loadFragment(new StoreFragment());
    }

    BottomNavigationView.OnNavigationItemSelectedListener mNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment;
                    switch (menuItem.getItemId()) {
                        case R.id.navigation_shop:
                            fragment = new StoreFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.navigation_gifts:
                            toolbar.setTitle("Gifts");
                            fragment = new GiftsFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.navigation_cart:
                            toolbar.setTitle("Cart");
                            fragment = new CartFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.navigation_profile:
                            toolbar.setTitle("Profile");
                            fragment = new ProfileFragment();
                            loadFragment(fragment);
                            return true;
                    }
                    return false;
                }
            };

    // == method ==
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
