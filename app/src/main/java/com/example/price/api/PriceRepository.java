package com.example.price.api;

import com.example.price.model.PriceData;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PriceRepository {
    private static PriceRepository priceRepository;

    public static PriceRepository getInstance() {

        if (priceRepository == null) {
            priceRepository = new PriceRepository();
        }
        return priceRepository;
    }

    private ApiInterface apiInterface;

    public PriceRepository() {
        apiInterface = APIClient.cteateService(ApiInterface.class);
    }

    public MutableLiveData<PriceData> getPrice() {
        final MutableLiveData<PriceData> priceData = new MutableLiveData<>();

        apiInterface.getTopPrices().enqueue(new Callback<PriceData>() {
            @Override
            public void onResponse(Call<PriceData> call, Response<PriceData> response) {
                if (response.isSuccessful()){
                    priceData.setValue(response.body());

                }

            }

            @Override
            public void onFailure(Call<PriceData> call, Throwable t) {
                priceData.setValue(null);

            }
        });
        return priceData;
    }
}
