package com.example.streamer;

import com.example.beans.StockEvent;
import com.example.beans.StockInventory;
import com.example.tracker.PriceTracker;
import io.micronaut.http.sse.Event;
import io.reactivex.rxjava3.core.Emitter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashSet;

@Singleton
public class PriceStreamer {

    @Inject
    private PriceTracker priceTracker;

    @Inject
    private StockInventory stockInventory;

    public void triggerEventForPrice(Emitter<Event<StockEvent>> emitter, String currentThread)   {
            if (priceTracker.shouldSendPriceUpdate(currentThread)) {
                emitter.onNext(
                        Event.of(new StockEvent("PRICE" , new HashSet<>(stockInventory.getStockPrices().values())))
                );
                priceTracker.updatePriceSendStatus(currentThread, false);
            }
    }

    public void registerStreamer(String threadName) {
        priceTracker.getPriceUpdate().put(threadName, true);
    }

}
