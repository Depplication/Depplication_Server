package com.project.Dion.domain.user.service;

import com.project.Dion.domain.user.presentation.dto.request.UserJoinRequest;
import com.project.Dion.domain.user.presentation.dto.request.UserLoginRequest;
import com.project.Dion.domain.user.presentation.dto.request.UserUpdateRequest;
import com.project.Dion.domain.user.presentation.dto.response.*;

public interface UserService {

    UserJoinResponse userJoin(UserJoinRequest userJoinRequestDto);

    UserLoginResponse userLogin(UserLoginRequest userLoginRequestDto);

    UserUpdateResponse userUpdate(String token, UserUpdateRequest userUpdateRequestDto);

    UserInfoResponse userInfo(String token);

    UserDeleteResponse userDelete(String token, String pw);


}
