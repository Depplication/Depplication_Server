package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.dto.request.OwnerDeleteRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerUpdateRequestDto;
import com.project.Dion.domain.owner.entity.Owner;
import com.project.Dion.domain.owner.exception.OwnerAlreadyExistsException;
import com.project.Dion.domain.owner.exception.OwnerNotFoundException;
import com.project.Dion.domain.owner.repository.OwnerRepository;
import com.project.Dion.global.exception.PasswordWrongException;
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
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final TokenService tService;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public Owner ownerLogin(OwnerLoginRequestDto ownerLoginRequestDto) {

        if(!ownerRepository.existsById(ownerLoginRequestDto.getId())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getById(ownerLoginRequestDto.getId());
        if(!passwordEncoder.matches(ownerLoginRequestDto.getPw(), owner.getPw())) {
            throw PasswordWrongException.EXCEPTION;
        }

        return owner;

    }

    @Override
    public Owner ownerJoin(OwnerJoinRequestDto ownerJoinRequestDto) {

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

        return ownerRepository.save(owner);
    }

    @Override
    public Owner ownerInfo(String token) {

        tService.checkToken(token);

        Claims claims = jwtProvider.parseJwtToken(token);

        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner ownerInfo = ownerRepository.getReferenceById(claims.getSubject());

        return ownerInfo;
    }

    @Override
    public Owner ownerUpdate(String token, OwnerUpdateRequestDto ownerUpdateRequestDto) {

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

        return owner;
    }

    @Override
    public void ownerDelete(String token, OwnerDeleteRequestDto ownerDeleteRequestDto) {

        tService.checkToken(token);

        Claims claims = jwtProvider.parseJwtToken(token);

        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(claims.getSubject());

        Owner deleteOwner = Owner.builder()
                .id(owner.getId())
                .pw(owner.getPw())
                .name(owner.getName())
                .address(owner.getAddress())
                .phone(owner.getPhone())
                .store(owner.getStore())
                .build();

        ownerRepository.delete(deleteOwner);
    }
}
