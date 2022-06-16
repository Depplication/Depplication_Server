package com.project.Dion.domain.user.service;

import com.project.Dion.domain.user.dto.request.*;
import com.project.Dion.domain.user.entity.User;


public interface UserService {

    User userJoin(UserJoinRequestDto userJoinRequestDto);

    User userLogin(UserLoginRequestDto userLoginRequestDto);

    User userUpdate(String token, UserUpdateRequestDto userUpdateRequestDto);

    User userInfo(String token);

    void userDelete(String token, UserDeleteRequestDto userDeleteRequestDto);


}
