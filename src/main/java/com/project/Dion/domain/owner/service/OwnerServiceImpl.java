package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.dto.request.OwnerInfoRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.entity.Owner;
import com.project.Dion.domain.owner.exception.OwnerAlreadyExistsException;
import com.project.Dion.domain.owner.exception.OwnerNotFoundException;
import com.project.Dion.domain.owner.repository.OwnerRepository;
import com.project.Dion.global.exception.PasswordWrongException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

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
    public Owner ownerInfo(OwnerInfoRequestDto ownerInfoRequestDto) {

        if(!ownerRepository.existsById(ownerInfoRequestDto.getId())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner ownerInfo = ownerRepository.getById(ownerInfoRequestDto.getId());

        return ownerInfo;
    }
}
