package com.example.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.instagram.Fragment.HomeFragment;
import com.example.instagram.Fragment.NotificationFragment;
import com.example.instagram.Fragment.ProfileFragment;
import com.example.instagram.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity  {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bottomNavigationView =findViewById(R.id.bottom_navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();





    }
   private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
           new BottomNavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                   switch (menuItem.getItemId()){

                       case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                           break;

                       case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                           break;

                       case R.id.nav_add:
                            selectedFragment = null;
                            startActivity(new Intent(MainActivity.this,PostActivity.class));
                           break;

                       case R.id.nav_heart:
                            selectedFragment = new NotificationFragment();
                           break;

                       case R.id.nav_profile:


                             selectedFragment = new ProfileFragment();
                           break;

                   }

                   if (selectedFragment != null){
                       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                               selectedFragment).commit();
                   }


                   return true;
               }
           };

}
