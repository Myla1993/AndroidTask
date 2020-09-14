package com.example.price.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.price.R;
import com.example.price.databinding.PriceChildLayoutBinding;
import com.example.price.model.Data;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.PriceViewHolde> {


    private LayoutInflater layoutInflater;
    private List<Data> listdata;
    private final Context context;

    public PriceAdapter(List<Data> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public PriceViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        PriceChildLayoutBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.price_child_layout, parent, false);

        return new PriceViewHolde(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PriceViewHolde holder, int position) {
      holder.binding.setObj(listdata.get(position));

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class PriceViewHolde extends RecyclerView.ViewHolder {
        private final PriceChildLayoutBinding binding;


        public PriceViewHolde(@NonNull PriceChildLayoutBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

        }
    }


    public void filterList(List<Data> listdat){
        listdata = listdat;
        notifyDataSetChanged();
    }

}
