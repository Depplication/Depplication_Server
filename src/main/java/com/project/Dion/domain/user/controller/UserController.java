package com.project.Dion.domain.user.controller;

import com.project.Dion.domain.user.dto.request.UserJoinRequestDto;
import com.project.Dion.domain.user.dto.request.UserLoginRequestDto;
import com.project.Dion.domain.user.dto.response.UserJoinResponse;
import com.project.Dion.domain.user.dto.response.UserLoginResponse;
import com.project.Dion.domain.user.entity.User;
import com.project.Dion.domain.user.service.UserServiceImpl;
import com.project.Dion.global.token.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
        User join = service.userJoin(dto);

        return new UserJoinResponse<User>(HttpStatus.OK, "회원가입 성공", join);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserLoginResponse<User> userLogin(
            @RequestBody UserLoginRequestDto dto
    ) {
        User login = service.userLogin(dto);

        return new UserLoginResponse<User>(HttpStatus.OK, "로그인 성공", login, tService.createToken(dto.getId()));
    }

}
