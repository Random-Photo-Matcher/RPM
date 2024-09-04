package com.rpm.rpm.archive;

import com.rpm.rpm.PhotoInfo;
import com.rpm.rpm.matching.Matching;
import com.rpm.rpm.users.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Archive {

    @Id @GeneratedValue
    @Column(name = "archive_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Matching matching;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="users_id")
    private Users user;

    @CreatedDate
    private LocalDateTime matchingTime;

    @Embedded
    private PhotoInfo photoInfo;
}
