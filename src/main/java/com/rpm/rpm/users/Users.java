package com.rpm.rpm.users;

import com.rpm.rpm.sending.Sending;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    @Id @Column(name = "users_id")
    private Long id;
    private String password;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sending> sendings = new ArrayList<>();
}
