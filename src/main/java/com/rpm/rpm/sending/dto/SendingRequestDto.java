package com.rpm.rpm.sending.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SendingRequestDto {
    private String userId;
    private BigDecimal latitude;
    private BigDecimal longitude;
}
