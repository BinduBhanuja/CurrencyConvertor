package com.example.currencyconvertor;

import com.example.currencyconvertor.models.Converter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ServiceManager {

    ConverterService converterService;

    @Inject
    public ServiceManager(ConverterService converterService) {
        this.converterService = converterService;
    }

    Observable<Converter> getConverterResponse(int fromAmount, String fromCurrency, String toCurrency) {
        return converterService.getConverterResponse(fromAmount, fromCurrency, toCurrency).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
