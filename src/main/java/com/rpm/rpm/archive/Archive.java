package com.rpm.rpm.archive;

import com.rpm.rpm.PhotoInfo;
import com.rpm.rpm.users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Archive {

    @Id @GeneratedValue
    @Column(name = "archive_id")
    private Long id;

    private Long matchingId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="users_id")
    private Users user;
    private LocalDateTime matchingTime;

    @Embedded
    private PhotoInfo photoInfo;
}
