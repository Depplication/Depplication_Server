package com.project.Dion.domain.user.service;

import com.project.Dion.domain.user.dto.request.*;
import com.project.Dion.domain.user.entity.User;
import com.project.Dion.global.exception.PasswordWrongException;
import com.project.Dion.domain.user.exception.UserAlreadyExistsException;
import com.project.Dion.domain.user.exception.UserNotFoundException;
import com.project.Dion.domain.user.repository.UserRepository;
import com.project.Dion.global.token.component.JwtProvider;
import com.project.Dion.global.token.service.TokenService;
import com.project.Dion.global.utils.UpdateUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final TokenService tService;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

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
                .address(userJoinRequestDto.getAddress())
                .build();

        return userRepository.save(user);
    }

    @Override
    public User userLogin(UserLoginRequestDto userLoginRequestDto) {

        if(!userRepository.existsById(userLoginRequestDto.getId())) {
            throw UserNotFoundException.EXCEPTION;
        }

        User user = userRepository.getReferenceById(userLoginRequestDto.getId());
        if(!passwordEncoder.matches(userLoginRequestDto.getPw(), user.getPw())) {
            throw PasswordWrongException.EXCEPTION;
        }

        return user;

    }

    @Override
    public User userUpdate(String token, UserUpdateRequestDto userUpdateRequestDto) {

        tService.checkToken(token);

        Claims claims = jwtProvider.parseJwtToken(token);

        if(!userRepository.existsById(claims.getSubject())) {
            throw UserNotFoundException.EXCEPTION;
        }

        Optional<User> userUpdate = userRepository.findById(claims.getSubject());
        User user = userRepository.getReferenceById(claims.getSubject());

        UpdateUtil<String> update = new UpdateUtil<>();

        userUpdate.ifPresent(m -> {
            m = User.builder()
                    .id(user.getId())
                    .pw(user.getPw())
                    .name(update.getUpdated(user.getName(), userUpdateRequestDto.getName()))
                    .phone(update.getUpdated(user.getPhone(), userUpdateRequestDto.getPhone()))
                    .account(update.getUpdated(user.getAccount(), userUpdateRequestDto.getAccount()))
                    .address(update.getUpdated(user.getAddress(), userUpdateRequestDto.getAddress()))
                    .build();

            userRepository.save(m);
        });

        return user;
    }

    @Override
    public User userInfo(String token) {

        tService.checkToken(token);

        Claims claims = jwtProvider.parseJwtToken(token);

        if(!userRepository.existsById(claims.getSubject())) {
            throw UserNotFoundException.EXCEPTION;
        }

        return userRepository.getReferenceById(claims.getSubject());
    }

    @Override
    public void userDelete(String token, UserDeleteRequestDto userDeleteRequestDto) {

        tService.checkToken(token);

        Claims claims = jwtProvider.parseJwtToken(token);
        User user = userRepository.getReferenceById(claims.getSubject());

        User deleteUser = User.builder()
                .id(user.getId())
                .pw(user.getPw())
                .name(user.getName())
                .phone(user.getPhone())
                .account(user.getAccount())
                .address(user.getAddress())
                .build();

        userRepository.delete(deleteUser);

    }
}
