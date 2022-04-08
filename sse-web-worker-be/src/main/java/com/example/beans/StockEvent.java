package com.example.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class StockEvent {

    private String eventType;

    private Set<? extends Stock> stocksData;

    @JsonCreator
    public StockEvent(
            @JsonProperty("eventType") String eventType,
            @JsonProperty("stockData") Set<? extends Stock> stocksData
    ) {
        this.eventType = eventType;
        this.stocksData = stocksData;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Set<? extends Stock> getStocksData() {
        return stocksData;
    }

    public void setStocksData(Set<? extends Stock> stocksData) {
        this.stocksData = stocksData;
    }


}
