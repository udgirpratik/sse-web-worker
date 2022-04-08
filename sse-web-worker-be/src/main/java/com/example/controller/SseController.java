package com.example.controller;

import com.example.beans.StockEvent;
import com.example.beans.StockInventory;
import com.example.beans.Stock;
import com.example.streamer.PriceStreamer;
import com.example.streamer.VolumeStreamer;
import com.example.tracker.VolumeTracker;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.sse.Event;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.inject.Inject;

import java.util.Set;
import java.util.logging.Logger;

@Controller("/sse")
public class SseController {

    private static final Logger log = Logger.getLogger(SseController.class.getName());

    @Inject
    private StockInventory quotesBean;

    @Inject
    private VolumeStreamer volumeStreamer;

    @Inject
    private PriceStreamer priceStreamer;

    @Inject
    private VolumeTracker volumeTracker;

    @Get(uri="/prices" , produces = MediaType.TEXT_EVENT_STREAM)
    @ExecuteOn(TaskExecutors.IO)
    public Flowable<Event<StockEvent>> sse() {
        // Determine queue to listen to
        String currentThread = Thread.currentThread().getName();
        registerTracker(currentThread);
        log.info(currentThread + " -- Registered");
        return Flowable.generate(() -> 0, (i, emitter) -> {
            // Get the message first...
            Thread.sleep(5000);
            if(i%2 ==0) {
                log.info(currentThread + " -- Streaming - Volume");
                volumeStreamer.triggerEventForVolume(emitter, currentThread);
            } else {
                log.info(currentThread + " -- Streaming - Price");
                priceStreamer.triggerEventForPrice(emitter, currentThread);
            }
            return i + 1;
        });


    }


    private void registerTracker(String threadName) {
        volumeStreamer.registerStreamer(threadName);
        priceStreamer.registerStreamer(threadName);
    }
}
