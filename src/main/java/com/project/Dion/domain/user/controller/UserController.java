package com.project.Dion.domain.user.controller;

import com.project.Dion.domain.user.dto.request.*;
import com.project.Dion.domain.user.dto.response.*;
import com.project.Dion.domain.user.entity.User;
import com.project.Dion.domain.user.service.UserServiceImpl;
import com.project.Dion.global.token.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl service;
    private final TokenService tService;

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public UserJoinResponse<User> userJoin(
            @RequestBody UserJoinRequestDto dto
    ) {

        return new UserJoinResponse<User>(HttpStatus.OK, "회원가입 성공", service.userJoin(dto));
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserLoginResponse<User> userLogin(
            @RequestBody UserLoginRequestDto dto
    ) {
        return new UserLoginResponse<User>(HttpStatus.OK, "로그인 성공", service.userLogin(dto), tService.createToken(dto.getId()));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public UserUpdateResponse<User> userUpdate(
            @RequestHeader String authorization,
            @RequestBody UserUpdateRequestDto dto
    ) {
        return new UserUpdateResponse<User>(HttpStatus.OK, "업데이트 성공", service.userUpdate(authorization, dto));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public UserDeleteResponse userDelete(
            @RequestHeader String authorization,
            @RequestBody UserDeleteRequestDto dto
    ) {
        service.userDelete(authorization, dto);

        return new UserDeleteResponse(HttpStatus.OK, "삭제 성공");
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public UserInfoResponse<User> userInfo(
            @RequestHeader String authorization
    ) {
        return new UserInfoResponse<User>(HttpStatus.OK, "유저 정보 불러오기 성공", service.userInfo(authorization));
    }

}
