package com.rpm.rpm;

import jakarta.persistence.Embeddable;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Embeddable
public class PhotoInfo {
    private Location location;
    private String imgUrl;

    @CreatedDate
    private LocalDateTime sendTime;
}
