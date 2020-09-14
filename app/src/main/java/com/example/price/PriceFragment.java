package com.example.price;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.price.adapter.PriceAdapter;
import com.example.price.model.Data;
import com.example.price.model.PriceData;
import com.example.price.viewmodel.PriceViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class PriceFragment extends Fragment {

    ArrayList<Data> pricelist = new ArrayList<Data>();
    PriceViewModel priceViewModel;
    PriceAdapter adapter;
    RecyclerView price_recyclerview;
    EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_price, container, false);
        price_recyclerview = view.findViewById(R.id.price_recyclerview);
        editText = view.findViewById(R.id.edt_search);
        priceViewModel = ViewModelProviders.of(getActivity()).get(PriceViewModel.class);
        priceViewModel.init();
        priceViewModel.getPriceRepository().observe(getActivity(), new Observer<PriceData>() {
            @Override
            public void onChanged(PriceData priceData) {
                pricelist.clear();
                pricelist .addAll(priceData.getData());

                adapter.notifyDataSetChanged();
            }
        });


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());

            }
        });
        setUpRecyclerView();


        return view;

    }

    private void setUpRecyclerView(){
        if (adapter == null){
            adapter = new PriceAdapter(pricelist,getActivity());
            price_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
            price_recyclerview.setAdapter(adapter);
            price_recyclerview.setItemAnimator(new DefaultItemAnimator());
            price_recyclerview.setNestedScrollingEnabled(true);
        }

    }

    public void filter(String txt) {
        List<Data> priceData = new ArrayList<>();
        for (Data d : pricelist) {
            if (d.getName().toLowerCase().contains(txt.toLowerCase())) {
                priceData.add(d);
            }
        }
        adapter.filterList(priceData);
    }


}
