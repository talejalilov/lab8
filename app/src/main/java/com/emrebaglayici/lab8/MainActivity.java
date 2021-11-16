package com.emrebaglayici.lab8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.emrebaglayici.lab8.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements   NavigationView.OnNavigationItemSelectedListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        setSupportActionBar(binding.layoutToolBar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");

//Burada biz toggle -da kullana bilirdik o zaman daha çok if bloğu kullanıcaktık ama NavController teknlojisi ile Menu - daki itemların ID-leri ile Navigation.xml ID - leri aynı yaparak tıklanan Fragmente götürüyor bizi
        binding.imageMenu.setOnClickListener(view -> binding.drawerLayout.openDrawer(GravityCompat.START));

        binding.floatingActionButton.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());



            NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
            NavigationUI.setupWithNavController(binding.navigationView, navController);

            navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

                binding.navigationView.setNavigationItemSelectedListener(this);

                binding.textTitle.setText(destination.getLabel());


                CharSequence fragmentLabel = destination.getLabel();

                assert fragmentLabel != null;
                if ("Home".contentEquals(fragmentLabel)) {
                    binding.floatingActionButton.show();

                } else if ("Movies".contentEquals(fragmentLabel)) {

                    binding.floatingActionButton.hide();

                } else if ("Notifications".contentEquals(fragmentLabel)) {

                    binding.floatingActionButton.hide();

                } else if ("Photos".contentEquals(fragmentLabel)) {
                    binding.floatingActionButton.hide();

                } else if ("Settings".contentEquals(fragmentLabel)) {
                    binding.floatingActionButton.hide();

                }
            });


        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.aboutUsId){
            startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
        } else if(item.getItemId()==R.id.privacyId){
            startActivity(new Intent(getApplicationContext(), PrivacyActivity.class));
        }
        return true;
    }
}

