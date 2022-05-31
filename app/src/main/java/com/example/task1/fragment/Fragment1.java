package com.example.task1.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.task1.adapter.ApiListAdapter;
import com.example.task1.databinding.FragmentApiBinding;
import com.example.task1.interfaces.OnItemClickListener;
import com.example.task1.interfaces.SendAPIData;
import com.example.task1.model.APIData;
import com.example.task1.viewmodel.APIViewModel;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements OnItemClickListener {

    private FragmentApiBinding binding;
    private ApiListAdapter adapter;
    private APIViewModel apiViewModel;
    private SendAPIData sendAPIData;
    private List<APIData> listOfAPIs= new ArrayList<>();

    public static Fragment1 newInstance() {
        return  new Fragment1();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendAPIData = (SendAPIData) requireActivity();
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
        apiViewModel= ViewModelProviders.of(requireActivity()).get(APIViewModel.class);
        setApiAdapter();
        fetchAPIData();
    }

    private void fetchAPIData() {
        binding.pbLoader.setVisibility(View.VISIBLE);
        apiViewModel.fetchAPIDataThroughRepo().observe(getViewLifecycleOwner(),apiData->{
            binding.pbLoader.setVisibility(View.GONE);
            listOfAPIs.addAll(apiData.entries);
            adapter.setAPIDataList(apiData.entries);
        });
    }

    private void setApiAdapter() {
        binding.rvAPIList.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new ApiListAdapter();
        binding.rvAPIList.setAdapter(adapter);
        adapter.setListener(this);
    }


    @Override
    public void onItemClick(int position) {
        if (sendAPIData != null){
            sendAPIData.sendData(listOfAPIs.get(position));
        }
    }
}