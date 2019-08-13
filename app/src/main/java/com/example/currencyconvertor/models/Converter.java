package com.example.currencyconvertor.models;

import com.google.gson.annotations.SerializedName;

public class Converter {

    @SerializedName("from")
    private String fromCurrency;

    @SerializedName("to")
    private String toCurrency;

    @SerializedName("from_amount")
    private int fromAmount;

    @SerializedName("to_amount")
    private Double toAmount;

    public Double getToAmount() {
        return toAmount;
    }
}
