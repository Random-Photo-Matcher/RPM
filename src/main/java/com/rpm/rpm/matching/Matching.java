package com.rpm.rpm.matching;

import com.rpm.rpm.sending.Sending;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Matching {
    @Id @GeneratedValue
    @Column(name = "matching_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sending sending1;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sending sending2;

    @CreatedDate
    private LocalDateTime matchingTime;

    public Matching(Sending sending1, Sending sending2) {
        this.sending1 = sending1;
        this.sending2 = sending2;
    }

    public Matching(List<Sending> sendings){
        this(sendings.get(0), sendings.get(1));

        // sendings의 길이는 무조건 2여야한다.
        if(sendings.size() != 2){
            throw new IllegalArgumentException("sendings는 2의 길이를 요구합니다.");
        }
    }
}
