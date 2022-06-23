package com.project.Dion.domain.user.service;

import com.project.Dion.domain.user.presentation.dto.request.UserJoinRequestDto;
import com.project.Dion.domain.user.presentation.dto.request.UserLoginRequestDto;
import com.project.Dion.domain.user.presentation.dto.request.UserUpdateRequestDto;
import com.project.Dion.domain.user.presentation.dto.response.*;


public interface UserService {

    UserJoinResponse userJoin(UserJoinRequestDto userJoinRequestDto);

    UserLoginResponse userLogin(UserLoginRequestDto userLoginRequestDto);

    UserUpdateResponse userUpdate(String token, UserUpdateRequestDto userUpdateRequestDto);

    UserInfoResponse userInfo(String token);

    UserDeleteResponse userDelete(String token, String pw);


}
