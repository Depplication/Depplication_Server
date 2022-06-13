package com.project.Dion.domain.user.controller;

import com.project.Dion.domain.user.dto.request.UserJoinRequestDto;
import com.project.Dion.domain.user.dto.response.UserJoinResponse;
import com.project.Dion.domain.user.entity.User;
import com.project.Dion.domain.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl service;

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public UserJoinResponse<User> userJoin(
            @RequestBody UserJoinRequestDto dto
    ) {
        User join = service.userJoin(dto);

        return new UserJoinResponse<User>(HttpStatus.OK, "회원가입 성공", join);
    }

}
