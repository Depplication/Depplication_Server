package com.project.Dion.domain.user.presentation;

import com.project.Dion.domain.user.presentation.dto.request.UserJoinRequestDto;
import com.project.Dion.domain.user.presentation.dto.request.UserLoginRequestDto;
import com.project.Dion.domain.user.presentation.dto.request.UserUpdateRequestDto;
import com.project.Dion.domain.user.presentation.dto.response.*;
import com.project.Dion.domain.user.service.UserServiceImpl;
import com.project.Dion.global.token.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl service;
    private final TokenService tService;

    @PostMapping("/join")
    public UserJoinResponse userJoin(
            @RequestBody UserJoinRequestDto dto
    ) {
        return service.userJoin(dto);
    }

    @PostMapping("/login")
    public UserLoginResponse userLogin(
            @RequestBody UserLoginRequestDto dto
    ) {
        return service.userLogin(dto);
    }

    @PatchMapping("/update")
    public UserUpdateResponse userUpdate(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody UserUpdateRequestDto dto
    ) {
        return service.userUpdate(token, dto);
    }

    @DeleteMapping("/delete")
    public UserDeleteResponse userDelete(
            @RequestHeader(value = "Authorization") String token,
            @PathVariable String pw
    ) {
        return service.userDelete(token, pw);
    }

    @GetMapping("/info")
    public UserInfoResponse userInfo(
            @RequestHeader(value = "Authorization") String token
    ) {
        return service.userInfo(token);
    }

}
