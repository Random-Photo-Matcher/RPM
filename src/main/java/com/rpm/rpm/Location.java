package com.rpm.rpm;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location {
    private BigDecimal latitude;
    private BigDecimal longitude;

    private Location(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static Location of(BigDecimal latitude, BigDecimal longitude){
        return new Location(latitude, longitude);
    }
}
