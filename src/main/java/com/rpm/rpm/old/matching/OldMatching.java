package com.rpm.rpm.old.matching;

import com.rpm.rpm.old.sending.OldSending;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OldMatching {
    @Id @GeneratedValue
    @Column(name = "old_mating_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OldSending oldSending1;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OldSending oldSending2;

    private LocalDateTime matchingTime;
}
