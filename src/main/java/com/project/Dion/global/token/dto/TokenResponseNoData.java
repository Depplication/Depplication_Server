package com.project.Dion.global.token.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TokenResponseNoData {

    private String code;
    private String msg;

}
