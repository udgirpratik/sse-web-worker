package com.example.tracker;

import jakarta.inject.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class PriceTracker {

    private final Map<String, Boolean> priceUpdate = new ConcurrentHashMap<>();


    public boolean shouldSendPriceUpdate(String userThread) {
        return priceUpdate.get(userThread);
    }

    public void updatePriceSendStatus(String userThread, boolean value) {
        priceUpdate.put(userThread, value);
    }


    public Map<String, Boolean> getPriceUpdate() {
        return priceUpdate;
    }


}
