package com.rpm.rpm.sending;

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
public class Sending {
    @Id @GeneratedValue
    @Column(name = "sending_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="users_id")
    private Users sender;

    @Embedded
    private Location location;
    private String img;
    private LocalDateTime sendingTime;
    @Enumerated(EnumType.STRING)
    private SendingStatus status; // READY, MATCHED
}
