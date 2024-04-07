package com.rpm.rpm.matched;

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
public class Matched {

    @Id @GeneratedValue
    private Long id;

    private Long matchedId;

    @OneToOne
    @JoinColumn(name="users_id")
    private Users user;
    private LocalDateTime matchingTime;

    @Embedded
    private PhotoInfo photoInfo;
}
