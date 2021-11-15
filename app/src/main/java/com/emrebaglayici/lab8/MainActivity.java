package com.emrebaglayici.lab8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.emrebaglayici.lab8.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity   {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageMenu.setOnClickListener(view -> binding.drawerLayout.openDrawer(GravityCompat.START));

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

    }



}