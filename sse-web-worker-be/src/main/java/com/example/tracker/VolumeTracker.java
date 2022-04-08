package com.example.tracker;

import jakarta.inject.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class VolumeTracker {

    private final Map<String, Boolean> volumeUpdate = new ConcurrentHashMap<>();

    public Map<String, Boolean> getVolumeUpdate() {
        return volumeUpdate;
    }

    public boolean shouldSendVolumeUpdate(String userThread) {
        return volumeUpdate.get(userThread);
    }

    public void updateVolumeSendStatus(String userThread, boolean value) {
        volumeUpdate.put(userThread, value);
    }


}
