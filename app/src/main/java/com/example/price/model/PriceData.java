package com.example.price.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceData {

    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("timestamp")
    @Expose
    private Double timestamp;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

}
