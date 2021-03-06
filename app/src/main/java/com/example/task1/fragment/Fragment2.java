package com.example.task1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.task1.adapter.ApiListAdapter;
import com.example.task1.databinding.FragmentApiBinding;
import com.example.task1.model.APIData;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {
    private FragmentApiBinding binding;
    private ApiListAdapter adapter;
    private List<APIData> listOfAPIs = new ArrayList<>();

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentApiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setApiAdapter();


    }

    private void setApiAdapter() {
        binding.rvAPIList.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter= new ApiListAdapter();
        binding.rvAPIList.setAdapter(adapter);

    }

    public void displayReceivedData(APIData apiData){
        listOfAPIs.add(apiData);
        adapter.setAPIDataList(listOfAPIs);
    }
}