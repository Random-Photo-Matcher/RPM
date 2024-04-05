package com.rpm.rpm.old.sending;

import com.rpm.rpm.Location;
import com.rpm.rpm.users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OldSending {
    @Id @GeneratedValue
    @Column(name = "old_sending_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="sender_id")
    private Users users;
    @Embedded
    private Location location;
    private String img;
    private LocalDateTime sendingTime;

}
