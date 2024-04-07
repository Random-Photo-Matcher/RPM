package com.rpm.rpm;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class PhotoInfo {
    private Location location;
    private String imgUrl;
    private LocalDateTime sentTime;
}
