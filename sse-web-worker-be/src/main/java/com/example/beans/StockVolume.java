package com.example.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StockVolume extends Stock {

    private Long volume;

    @JsonCreator
    public StockVolume(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("volume") Long volume
    ) {
        super(id, name);
        this.volume = volume;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StockVolume that = (StockVolume) o;
        return Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }
}
