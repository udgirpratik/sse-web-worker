package com.example.streamer;

import com.example.beans.StockEvent;
import com.example.beans.StockInventory;
import com.example.tracker.VolumeTracker;
import io.micronaut.http.sse.Event;
import io.reactivex.rxjava3.core.Emitter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashSet;

@Singleton
public class VolumeStreamer {

    @Inject
    private VolumeTracker volumeTracker;

    @Inject
    private StockInventory stockInventory;

    public void triggerEventForVolume(Emitter<Event<StockEvent>> emitter, String currentThread)   {
        if (volumeTracker.shouldSendVolumeUpdate(currentThread)) {
            emitter.onNext(
                    Event.of(new StockEvent("VOLUME" , new HashSet<>(stockInventory.getStockVolumes().values())))
            );
            volumeTracker.updateVolumeSendStatus(currentThread, false);
        }
    }

    public void registerStreamer(String threadName) {
        volumeTracker.getVolumeUpdate().put(threadName, true);
    }

}
