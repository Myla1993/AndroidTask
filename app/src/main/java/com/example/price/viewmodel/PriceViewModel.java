package com.example.price.viewmodel;

import com.example.price.api.PriceRepository;
import com.example.price.model.PriceData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PriceViewModel extends ViewModel {

    private MutableLiveData<PriceData> mutableLiveData;
    private PriceRepository priceRepository;

    public void init(){

        if (mutableLiveData != null){
            return;
        }
        priceRepository = PriceRepository.getInstance();
        mutableLiveData = priceRepository.getPrice();
    }

    public LiveData<PriceData> getPriceRepository(){
        return mutableLiveData;
    }
}
