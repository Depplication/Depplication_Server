package com.project.Dion.domain.user.service;

import com.project.Dion.domain.user.dto.request.*;
import com.project.Dion.domain.user.entity.User;


public interface UserService {

    User userJoin(UserJoinRequestDto userJoinRequestDto);

    User userLogin(UserLoginRequestDto userLoginRequestDto);

    User userUpdate(UserUpdateRequestDto userUpdateRequestDto);

    User userInfo(UserInfoRequestDto userInfoRequestDto);

    void userDelete(UserDeleteRequestDto userDeleteRequestDto);


}
