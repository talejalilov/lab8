package com.emrebaglayici.lab8;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.emrebaglayici.lab8.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;


public class MainActivity extends AppCompatActivity   {


    ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.layoutToolBar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");

        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.drawer_open, R.string.drawer_close);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





//        binding.imageMenu.setOnClickListener(view -> binding.drawerLayout.openDrawer(GravityCompat.START));

        binding.floatingActionButton.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());


        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(binding.navigationView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

            binding.textTitle.setText(destination.getLabel());


            CharSequence fragmentLabel = destination.getLabel();

            assert fragmentLabel != null;
            if ("Home".contentEquals(fragmentLabel)) {
                binding.floatingActionButton.show();

            }
            else if("Movies".contentEquals(fragmentLabel)){

                binding.floatingActionButton.hide();

            }
            else if("Notifications".contentEquals(fragmentLabel)){

                binding.floatingActionButton.hide();

            }

            else if("Photos".contentEquals(fragmentLabel)){
                binding.floatingActionButton.hide();

            }

            else if("Settings".contentEquals(fragmentLabel)){
                binding.floatingActionButton.hide();

            }
        });

    binding.navigationView.setNavigationItemSelectedListener(item -> {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        selectDrawerItem(item);
        return true;
    });


    }

    @SuppressLint("NonConstantResourceId")
    public void selectDrawerItem(MenuItem menuItem) {

        switch(menuItem.getItemId()) {
            case R.id.aboutUsId:
                startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                break;

            case R.id.privacyId:
                startActivity(new Intent(MainActivity.this, PrivacyActivity.class));
                break;
        }
    }

}
