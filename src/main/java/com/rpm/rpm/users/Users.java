package com.rpm.rpm.users;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {
    @Id @GeneratedValue
    @Column(name = "users_id")
    private Long id;
    private String loginId;
    private String password;
}
