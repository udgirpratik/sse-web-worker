package com.example.beans;

import com.example.tracker.PriceTracker;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Singleton
public class StockInventory {

    private final Map<String,  Stock> stockVolumes = new HashMap<>();

    private final Map<String,  Stock> stockPrices = new HashMap<>();

    StockInventory() {
        initializeStockVolumes();
        initializeStockPries();
    }

    private void initializeStockVolumes() {
        stockVolumes.put("INFY", new StockVolume("INFY", "INFOSYS", 0L));
        stockVolumes.put("TCS", new StockVolume("TCS", "Tata Consultancy Services", 0L));
    }

    private void initializeStockPries() {
        stockPrices.put("INFY", new StockPrice("INFY", "INFOSYS", 0.0d));
        stockPrices.put("TCS", new StockPrice("TCS", "Tata Consultancy Services", 0.0d));
    }

    public void updatePrice (String id, Double price) {
        StockPrice stock = (StockPrice) stockPrices.get(id);
        stock.setPrice(price);
    }

    public void updateVolume (String id, Long volume) {
        StockVolume stock = (StockVolume) stockVolumes.get(id);
        stock.setVolume(volume);
    }

    public Map<String, Stock> getStockVolumes() {
        return stockVolumes;
    }

    public Map<String, Stock> getStockPrices() {
        return stockPrices;
    }
}
