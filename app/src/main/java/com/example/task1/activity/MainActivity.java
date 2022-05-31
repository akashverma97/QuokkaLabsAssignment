package com.example.task1.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.task1.R;
import com.example.task1.fragment.Fragment1;
import com.example.task1.fragment.Fragment2;
import com.example.task1.interfaces.SendAPIData;
import com.example.task1.model.APIData;

public class MainActivity extends AppCompatActivity implements SendAPIData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragments();

    }

    private void loadFragments() {
        //loading first fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment1, Fragment1.newInstance(), "Fragment1");

        //loading second fragment
        ft.add(R.id.fragment2, Fragment2.newInstance(), "Fragment2");
        ft.commit();


    }

    @Override
    public void sendData(APIData apiData) {
        Fragment2 fragment = (Fragment2) getSupportFragmentManager().findFragmentByTag("Fragment2");
        if (fragment != null)
            fragment.displayReceivedData(apiData);
    }
}