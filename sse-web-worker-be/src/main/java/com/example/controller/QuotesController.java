package com.example.controller;

import com.example.beans.StockInventory;
import com.example.beans.StockPrice;
import com.example.beans.StockVolume;
import com.example.tracker.PriceTracker;
import com.example.tracker.VolumeTracker;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.util.Set;

@Controller("/quotes")
public class QuotesController {

    @Inject
    StockInventory stockInventory;

    @Inject
    PriceTracker priceTracker;

    @Inject
    VolumeTracker volumeTracker;

    @Post("/updatePrice")
    public HttpResponse<Void> updatePrice (StockPrice stockPrice) {
        Set<String> keys = priceTracker.getPriceUpdate().keySet();
        for(String key : keys) {
            priceTracker.getPriceUpdate().put(key, true);
        }
        stockInventory.updatePrice(stockPrice.getId(), stockPrice.getPrice());
        return HttpResponse.ok();
    }

    @Post("/updateVolume")
    public HttpResponse<Void> updateVolume (StockVolume stockVolume) {
        Set<String> keys = volumeTracker.getVolumeUpdate().keySet();
        for(String key : keys) {
            volumeTracker.getVolumeUpdate().put(key, true);
        }
        stockInventory.updateVolume(stockVolume.getId(), stockVolume.getVolume());
        return HttpResponse.ok();
    }
}
