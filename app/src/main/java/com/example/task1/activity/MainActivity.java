package com.example.task1.activity;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.task1.fragment.Fragment1;
import com.example.task1.fragment.Fragment2;
import com.example.task1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragments();

    }

    private void loadFragments() {
        //loading first fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment1,new Fragment1(), "Fragment1");
//        ft.commit();

        //loading second fragment
        ft.add(R.id.fragment2,new Fragment2(), "Fragment2");
        ft.commit();


    }
}