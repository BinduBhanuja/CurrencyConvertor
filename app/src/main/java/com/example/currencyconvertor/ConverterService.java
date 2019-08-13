package com.example.currencyconvertor;

import com.example.currencyconvertor.models.Converter;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ConverterService {

    @Headers({
            "X-RapidAPI-Host: currencyconverter.p.rapidapi.com",
            "X-RapidAPI-Key: a0155a14c1msh2e220116b4e5552p1405a5jsn396c273e9ee3"
    })
    @GET("/")
    Observable<Converter> getConverterResponse(@Query("from_amount") int fromAmount, @Query("from") String fromCurrency, @Query("to") String toCurrency);
}
