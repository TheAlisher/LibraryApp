package com.example.libraryapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.libraryapp.R;
import com.example.libraryapp.ui.models.BookModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openMainFragment();
    }

    private void openMainFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_main_container, new MainFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        String currentFragmentName =
                getSupportFragmentManager().findFragmentById(R.id.frame_main_container).getClass().getSimpleName();
        if (currentFragmentName.equals("MainFragment")) {
            super.onBackPressed();
        } else {
            openMainFragment();
        }
    }
}