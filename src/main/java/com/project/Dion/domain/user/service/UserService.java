package com.project.Dion.domain.user.service;

import com.project.Dion.domain.user.dto.request.UserDeleteRequestDto;
import com.project.Dion.domain.user.dto.request.UserJoinRequestDto;
import com.project.Dion.domain.user.dto.request.UserLoginRequestDto;
import com.project.Dion.domain.user.entity.User;

public interface UserService {

    User userJoin(UserJoinRequestDto userJoinRequestDto);

    User userLogin(UserLoginRequestDto userLoginRequestDto);

    User userUpdate(UserDeleteRequestDto userDeleteRequestDto);

    User userInfo();

    void userDelete();


}
