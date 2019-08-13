package com.example.currencyconvertor;

import android.util.Log;

import androidx.databinding.ObservableDouble;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LifecycleObserver;

import com.example.currencyconvertor.models.Converter;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainViewModel implements LifecycleObserver {

    public ObservableField<String> fromAmountString = new ObservableField<>("10");
    public ObservableInt selectedPositionFrom = new ObservableInt();
    public ObservableInt selectedPositionTo = new ObservableInt();

    private ObservableDouble toAmount = new ObservableDouble(0.0);
    private List<String> currencyList = Arrays.asList("AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYN", "BYR", "BZD", "CAD", "CDF", "CHF", "CLF", "CLPCNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "STD", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMK", "ZMW", "ZWL");
    private int fromAmount;
    private String fromCurrency, toCurrency;

    public List<String> getCurrencyList() {
        return currencyList;
    }

    public String getToAmount() {
        return String.valueOf(toAmount.get());
    }

    ServiceManager serviceManager;

    @Inject
    public MainViewModel(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    public void onClick() {
        fromCurrency = currencyList.get(selectedPositionFrom.get());
        toCurrency = currencyList.get(selectedPositionTo.get());
        fromAmount = Integer.valueOf(fromAmountString.get());
        onServiceCall();
    }

    private void onServiceCall() {
        serviceManager.getConverterResponse(fromAmount, fromCurrency, toCurrency).subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(Converter converter) {
        toAmount.set(converter.getToAmount());
    }

    private void onError(Throwable throwable) {
        Log.e(TAG, "onError: " + throwable.getLocalizedMessage());
    }
}
