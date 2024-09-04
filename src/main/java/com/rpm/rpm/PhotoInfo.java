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

    public PhotoInfo(Location location, String imgUrl) {
        this.imgUrl = imgUrl;
        this.location = location;
        // sendTime은 @CreateDate이므로 null로 DB에 들어갈 때 자동으로 입력됨.
    }
}
