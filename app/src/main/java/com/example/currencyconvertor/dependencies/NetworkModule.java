package com.example.currencyconvertor.dependencies;

import com.example.currencyconvertor.ConverterService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String BASE_URL = "https://currencyconverter.p.rapidapi.com";

    @Singleton
    @Provides
    public ConverterService getServiceInstance() {
        return new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ConverterService.class);
    }
}
