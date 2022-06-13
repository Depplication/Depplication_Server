package com.project.Dion.domain.user.service;

import com.project.Dion.domain.user.dto.request.UserDeleteRequestDto;
import com.project.Dion.domain.user.dto.request.UserJoinRequestDto;
import com.project.Dion.domain.user.dto.request.UserLoginRequestDto;
import com.project.Dion.domain.user.entity.User;
import com.project.Dion.domain.user.exception.UserAlreadyExistsException;
import com.project.Dion.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User userJoin(UserJoinRequestDto userJoinRequestDto) {

        userRepository.findById(userJoinRequestDto.getId()).ifPresent(m -> {
            throw UserAlreadyExistsException.EXCEPTION;
        });

        User user = User.builder()
                .id(userJoinRequestDto.getId())
                .pw(passwordEncoder.encode(userJoinRequestDto.getPw()))
                .name(userJoinRequestDto.getName())
                .phone(userJoinRequestDto.getPhone())
                .account(userJoinRequestDto.getAccount())
                .build();

        return userRepository.save(user);
    }

    @Override
    public User userLogin(UserLoginRequestDto userLoginRequestDto) {
        return null;
    }

    @Override
    public User userUpdate(UserDeleteRequestDto userDeleteRequestDto) {
        return null;
    }

    @Override
    public User userInfo() {
        return null;
    }

    @Override
    public void userDelete() {

    }
}
