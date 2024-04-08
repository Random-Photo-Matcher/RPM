package com.rpm.rpm.sending;

import com.rpm.rpm.PhotoInfo;
import com.rpm.rpm.users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sending {
    @Id @GeneratedValue
    @Column(name = "sending_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="users_id")
    private Users user;

    @Embedded
    private PhotoInfo photoInfo;
    @Enumerated(EnumType.STRING)
    private SendingStatus status; // READY, MATCHED
}
