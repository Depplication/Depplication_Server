package com.project.Dion.domain.user.presentation;

import com.project.Dion.domain.user.presentation.dto.request.UserJoinRequest;
import com.project.Dion.domain.user.presentation.dto.request.UserLoginRequest;
import com.project.Dion.domain.user.presentation.dto.request.UserUpdateRequest;
import com.project.Dion.domain.user.presentation.dto.response.*;
import com.project.Dion.domain.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl service;

    @PostMapping("/join")
    public UserJoinResponse userJoin(
            @RequestBody UserJoinRequest dto
    ) {
        return service.userJoin(dto);
    }

    @PostMapping("/login")
    public UserLoginResponse userLogin(
            @RequestBody UserLoginRequest dto
    ) {
        return service.userLogin(dto);
    }

    @PatchMapping("/update")
    public UserUpdateResponse userUpdate(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody UserUpdateRequest dto

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
