package com.example.task1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.databinding.AdapterApiListBinding;
import com.example.task1.interfaces.OnItemClickListener;
import com.example.task1.model.APIData;

import java.util.Collections;
import java.util.List;

public class ApiListAdapter extends RecyclerView.Adapter<ApiListAdapter.ViewHolder> {

    private List<APIData> listOfAPIs = Collections.emptyList();
    private OnItemClickListener listener = null;

    public void setAPIDataList(List<APIData> listOfAPIs){
        this.listOfAPIs = listOfAPIs;
        notifyDataSetChanged();
    }

    public void setListener(OnItemClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(AdapterApiListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(listOfAPIs.get(position));
    }

    @Override
    public int getItemCount() {
        return listOfAPIs.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterApiListBinding binding;


        public ViewHolder(AdapterApiListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(APIData apiData) {
            binding.tvAPIName.setText(apiData.API);
            binding.tvAPIDesc.setText(apiData.Description);

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAbsoluteAdapterPosition());
                }
            });
        }
    }
}


