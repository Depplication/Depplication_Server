package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.presentation.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerUpdateRequestDto;
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

    @Override
    public OwnerLoginResponse ownerLogin(OwnerLoginRequestDto ownerLoginRequestDto) {

        if(!ownerRepository.existsById(ownerLoginRequestDto.getId())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(ownerLoginRequestDto.getId());
        if(!passwordEncoder.matches(ownerLoginRequestDto.getPw(), owner.getPw())) {
            throw PasswordWrongException.EXCEPTION;
        }

        return new OwnerLoginResponse(HttpStatus.OK, "로그인 성공",
                owner.getId(),
                owner.getPw(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress(),
                tService.createToken(owner.getId()));

    }

    @Override
    public OwnerJoinResponse ownerJoin(OwnerJoinRequestDto ownerJoinRequestDto) {

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

        ownerRepository.save(owner);

        return new OwnerJoinResponse(HttpStatus.OK, "회원가입 성공");
    }

    @Override
    public OwnerInfoResponse ownerInfo(String token) {

        tService.checkToken(token);

        Claims claims = jwtProvider.parseJwtToken(token);

        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(claims.getSubject());

        return new OwnerInfoResponse(HttpStatus.OK, "업주정보 불러오기 성공",
                owner.getId(),
                owner.getPw(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress());
    }

    @Override
    public OwnerUpdateResponse ownerUpdate(String token, OwnerUpdateRequestDto ownerUpdateRequestDto) {

        tService.checkToken(token);

        Claims claims = jwtProvider.parseJwtToken(token);

        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Optional<Owner> ownerUpdate = ownerRepository.findById(claims.getSubject());
        Owner owner = ownerRepository.getReferenceById(claims.getSubject());

        UpdateUtil<String> update = new UpdateUtil<>();

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

        return new OwnerUpdateResponse(HttpStatus.OK, "업데이트 성공",
                owner.getId(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress());
    }

    @Override
    public OwnerDeleteResponse ownerDelete(String token, String pw) {

        tService.checkToken(token);

        Claims claims = jwtProvider.parseJwtToken(token);

        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(claims.getSubject());
        if(pw.equals(owner.getPw())) {
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

        ownerRepository.delete(deleteOwner);

        return new OwnerDeleteResponse(HttpStatus.OK, "삭제 성공");
    }
}
