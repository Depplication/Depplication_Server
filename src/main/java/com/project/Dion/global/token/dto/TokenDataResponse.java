package com.project.Dion.global.token.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class TokenDataResponse {

    private String token;
    private String subject;
    private String issued_time;
    private String expired_time;

    @Builder
    public TokenDataResponse(String token, String subject, String issued_time, String expired_time) {
        this.token = token;
        this.subject = subject;
        this.issued_time = issued_time;
        this.expired_time = expired_time;
    }
}
