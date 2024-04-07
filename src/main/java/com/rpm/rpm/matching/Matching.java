package com.rpm.rpm.matching;

import com.rpm.rpm.sending.Sending;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Matching {
    @Id @GeneratedValue
    @Column(name = "matching_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sending sendingId1;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sending sendingId2;
    private LocalDateTime matchingTime;
}
