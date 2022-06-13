package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.entity.Owner;
import com.project.Dion.domain.owner.exception.OwnerAlreadyExistsException;
import com.project.Dion.domain.owner.repository.OwnerRepository;
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
        return null;
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
    public Owner ownerInfo() {
        return null;
    }
}
