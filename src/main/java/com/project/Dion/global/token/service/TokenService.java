package com.project.Dion.global.token.service;

import com.project.Dion.global.token.component.JwtProvider;
import com.project.Dion.global.token.dto.TokenDataResponse;
import com.project.Dion.global.token.dto.TokenResponse;
import com.project.Dion.global.token.dto.TokenResponseNoData;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtProvider jwtProvider;

    /**
     * Token 발급
     * */
    public TokenResponse<TokenDataResponse> createToken(String userId) {
        String token = jwtProvider.createToken(userId);
        Claims claims = jwtProvider.parseJwtToken(token);

        TokenDataResponse tokenDataResponse = new TokenDataResponse(token,
                claims.getSubject(), claims.getIssuedAt().toString(),
                claims.getExpiration().toString());

        return new TokenResponse<TokenDataResponse>("200", "OK", tokenDataResponse);

    }

    /**
     * Token 인증
     * */
    public TokenResponseNoData checkToken(String token) {
        Claims claims = jwtProvider.parseJwtToken(token);

        return new TokenResponseNoData("200", "success");
    }

}
