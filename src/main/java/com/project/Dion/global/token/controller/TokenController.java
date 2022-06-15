package com.project.Dion.global.token.controller;

import com.project.Dion.global.token.component.JwtProvider;
import com.project.Dion.global.token.dto.TokenDataResponse;
import com.project.Dion.global.token.dto.TokenResponse;
import com.project.Dion.global.token.dto.TokenResponseNoData;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/token")
@RequiredArgsConstructor
public class TokenController {

    private final JwtProvider jwtProvider;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public TokenResponse<TokenDataResponse> createToken(
            @RequestParam("userId") String userId
    ) {
        String token = jwtProvider.createToken(userId);
        Claims claims = jwtProvider.parseJwtToken(token);

        TokenDataResponse tokenDataResponse = new TokenDataResponse(token,
                claims.getSubject(), claims.getIssuedAt().toString(),
                claims.getExpiration().toString());

        return new TokenResponse<TokenDataResponse>("200", "OK", tokenDataResponse);
    }

    @RequestMapping(value = "/checkToken", method = RequestMethod.GET)
    public TokenResponseNoData checkToken(
            @RequestHeader(value = "Authorization") String token
    ) {
        Claims claims = jwtProvider.parseJwtToken(token);

        return new TokenResponseNoData("200", "success");
    }

}
