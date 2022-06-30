package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.presentation.dto.request.OwnerJoinRequest;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerLoginRequest;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerUpdateRequest;
import com.project.Dion.domain.owner.entity.Owner;
import com.project.Dion.domain.owner.exception.OwnerAlreadyExistsException;
import com.project.Dion.domain.owner.exception.OwnerNotFoundException;
import com.project.Dion.domain.owner.presentation.dto.response.*;
import com.project.Dion.domain.owner.repository.OwnerRepository;
import com.project.Dion.global.exception.PasswordWrongException;
import com.project.Dion.global.token.component.JwtProvider;
import com.project.Dion.global.token.service.TokenService;
import com.project.Dion.global.utils.UpdateUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final TokenService tService;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    /**
     * 로그인
     * */
    @Override
    public OwnerLoginResponse ownerLogin(OwnerLoginRequest ownerLoginRequestDto) {

        /**
         * 아이디가 존재하는 지 체크
         * 존재하지 않으면 OwnerNotFoundException 예외 처리
         * */
        if(!ownerRepository.existsById(ownerLoginRequestDto.getId())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(ownerLoginRequestDto.getId()); // 아이디로 정보 얻기
        /**
         * 비밀번호가 맞는 지 체크
         * 맞지 않으면 PasswordWrongException 예외 처리
         * */
        if(!passwordEncoder.matches(ownerLoginRequestDto.getPw(), owner.getPw())) {
            throw PasswordWrongException.EXCEPTION;
        }

        /**
         * 로그인 Response 를 반환
         * */
        return new OwnerLoginResponse(HttpStatus.OK, "로그인 성공",
                owner.getId(),
                owner.getPw(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress(),
                tService.createToken(owner.getId()));

    }

    /**
     * 회원가입
     * */
    @Override
    public OwnerJoinResponse ownerJoin(OwnerJoinRequest ownerJoinRequestDto) {

        /**
         * 어아다가 존재하는 지 체크
         * 존재하면 OwnerAlreadyExistsException 예외 처리
         * */
        ownerRepository.findById(ownerJoinRequestDto.getId()).ifPresent(m -> {
            throw OwnerAlreadyExistsException.EXCEPTION;
        });

        Owner owner = Owner.builder()
                .id(ownerJoinRequestDto.getId())
                .pw(passwordEncoder.encode(ownerJoinRequestDto.getPw()))
                .name(ownerJoinRequestDto.getName())
                .store(ownerJoinRequestDto.getStoreName())
                .address(ownerJoinRequestDto.getAddress())
                .phone(ownerJoinRequestDto.getPhone())
                .build();

        ownerRepository.save(owner); // DB에 저장

        return new OwnerJoinResponse(HttpStatus.OK, "회원가입 성공");
    }

    /**
     * 정보 불러오기
     * */
    @Override
    public OwnerInfoResponse ownerInfo(String token) {

        tService.checkToken(token); // 토큰 확인

        Claims claims = jwtProvider.parseJwtToken(token); // 토큰 Parser

        /**
         * 아이디 존재하는 지 확인
         * 존재하지 않으면 OwnerNotFoundException 예외 처리
         * */

        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(claims.getSubject()); // 아이디로 정보 얻기

        /**
         * info Response 를 반환
         * */
        return new OwnerInfoResponse(HttpStatus.OK, "업주정보 불러오기 성공",
                owner.getId(),
                owner.getPw(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress());
    }

    /**
     * 정보 업데이트
     * */
    @Override
    public OwnerUpdateResponse ownerUpdate(String token, OwnerUpdateRequest ownerUpdateRequestDto) {

        tService.checkToken(token); //토큰 확인

        Claims claims = jwtProvider.parseJwtToken(token); // 토큰 Parser

        /**
         * 아이디 존재하는 지 확인
         * 존재하지 않으면 OwnerNotFoundException 예외 처리
         * */
        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Optional<Owner> ownerUpdate = ownerRepository.findById(claims.getSubject()); // 아이디로 정보 찾기
        Owner owner = ownerRepository.getReferenceById(claims.getSubject()); // 아이디로 정보 얻기

        UpdateUtil<String> update = new UpdateUtil<>(); // 들어온 값이 있는지 없는 지 확인

        ownerUpdate.ifPresent(m -> {
            m = Owner.builder()
                    .id(owner.getId())
                    .pw(owner.getPw())
                    .name(update.getUpdated(owner.getName(), ownerUpdateRequestDto.getName()))
                    .address(update.getUpdated(owner.getAddress(), ownerUpdateRequestDto.getAddress()))
                    .phone(update.getUpdated(owner.getPhone(), ownerUpdateRequestDto.getPhone()))
                    .store(update.getUpdated(owner.getStore(), ownerUpdateRequestDto.getStore()))
                    .build();

            ownerRepository.save(m);
        });

        /**
         * 업데이트 Response 를 반환
         * */
        return new OwnerUpdateResponse(HttpStatus.OK, "업데이트 성공",
                owner.getId(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress());
    }

    /**
     * 정보 삭제
     * */
    @Override
    public OwnerDeleteResponse ownerDelete(String token, String pw) {

        tService.checkToken(token); //토큰 확인

        Claims claims = jwtProvider.parseJwtToken(token); // 토큰 Parser

        /**
         * 아이디 존재하는 지 확인
         * 존재하지 않으면 OwnerNotFoundException 예외 처리
         * */
        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(claims.getSubject()); // 아이디로 정보 얻기

        /**
         * 비밀번호가 맞는 지 체크
         * 맞지 않으면 PasswordWrongException 예외 처리
         * */
        if(!passwordEncoder.matches(pw, owner.getPw())) {
            throw PasswordWrongException.EXCEPTION;
        }

        Owner deleteOwner = Owner.builder()
                .id(owner.getId())
                .pw(owner.getPw())
                .name(owner.getName())
                .address(owner.getAddress())
                .phone(owner.getPhone())
                .store(owner.getStore())
                .build();

        ownerRepository.delete(deleteOwner); // DB에 삭제

        return new OwnerDeleteResponse(HttpStatus.OK, "삭제 성공");
    }
}
