package com.emrebaglayici.lab8;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Objects;

public class NotificationsFragment extends Fragment {



    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
//
//
//       Toolbar mToolbar =  rootView.findViewById(R.id.layoutToolbar);
//        if (mToolbar != null) {
//            ((MainActivity) requireActivity()).setSupportActionBar(mToolbar);
//            mToolbar.setTitle("Home");
//        }


        return rootView;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.home_fragment_menu, menu);
        menu.findItem(R.id.markAllAsRead).setVisible(true);
        menu.findItem(R.id.clearAll).setVisible(true);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.markAllAsRead){
            Toast.makeText(getActivity(), "All mark Read", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.clearAll){
            Toast.makeText(getActivity(), " All Cleared ", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}