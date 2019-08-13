package com.example.currencyconvertor.dependencies;

import com.example.currencyconvertor.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ApplicationModule {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
