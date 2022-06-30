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
     * �α���
     * */
    @Override
    public OwnerLoginResponse ownerLogin(OwnerLoginRequest ownerLoginRequestDto) {

        /**
         * ���̵� �����ϴ� �� üũ
         * �������� ������ OwnerNotFoundException ���� ó��
         * */
        if(!ownerRepository.existsById(ownerLoginRequestDto.getId())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(ownerLoginRequestDto.getId()); // ���̵�� ���� ���
        /**
         * ��й�ȣ�� �´� �� üũ
         * ���� ������ PasswordWrongException ���� ó��
         * */
        if(!passwordEncoder.matches(ownerLoginRequestDto.getPw(), owner.getPw())) {
            throw PasswordWrongException.EXCEPTION;
        }

        /**
         * �α��� Response �� ��ȯ
         * */
        return new OwnerLoginResponse(HttpStatus.OK, "�α��� ����",
                owner.getId(),
                owner.getPw(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress(),
                tService.createToken(owner.getId()));

    }

    /**
     * ȸ������
     * */
    @Override
    public OwnerJoinResponse ownerJoin(OwnerJoinRequest ownerJoinRequestDto) {

        /**
         * ��ƴٰ� �����ϴ� �� üũ
         * �����ϸ� OwnerAlreadyExistsException ���� ó��
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

        ownerRepository.save(owner); // DB�� ����

        return new OwnerJoinResponse(HttpStatus.OK, "ȸ������ ����");
    }

    /**
     * ���� �ҷ�����
     * */
    @Override
    public OwnerInfoResponse ownerInfo(String token) {

        tService.checkToken(token); // ��ū Ȯ��

        Claims claims = jwtProvider.parseJwtToken(token); // ��ū Parser

        /**
         * ���̵� �����ϴ� �� Ȯ��
         * �������� ������ OwnerNotFoundException ���� ó��
         * */

        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(claims.getSubject()); // ���̵�� ���� ���

        /**
         * info Response �� ��ȯ
         * */
        return new OwnerInfoResponse(HttpStatus.OK, "�������� �ҷ����� ����",
                owner.getId(),
                owner.getPw(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress());
    }

    /**
     * ���� ������Ʈ
     * */
    @Override
    public OwnerUpdateResponse ownerUpdate(String token, OwnerUpdateRequest ownerUpdateRequestDto) {

        tService.checkToken(token); //��ū Ȯ��

        Claims claims = jwtProvider.parseJwtToken(token); // ��ū Parser

        /**
         * ���̵� �����ϴ� �� Ȯ��
         * �������� ������ OwnerNotFoundException ���� ó��
         * */
        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Optional<Owner> ownerUpdate = ownerRepository.findById(claims.getSubject()); // ���̵�� ���� ã��
        Owner owner = ownerRepository.getReferenceById(claims.getSubject()); // ���̵�� ���� ���

        UpdateUtil<String> update = new UpdateUtil<>(); // ���� ���� �ִ��� ���� �� Ȯ��

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
         * ������Ʈ Response �� ��ȯ
         * */
        return new OwnerUpdateResponse(HttpStatus.OK, "������Ʈ ����",
                owner.getId(),
                owner.getName(),
                owner.getPhone(),
                owner.getStore(),
                owner.getAddress());
    }

    /**
     * ���� ����
     * */
    @Override
    public OwnerDeleteResponse ownerDelete(String token, String pw) {

        tService.checkToken(token); //��ū Ȯ��

        Claims claims = jwtProvider.parseJwtToken(token); // ��ū Parser

        /**
         * ���̵� �����ϴ� �� Ȯ��
         * �������� ������ OwnerNotFoundException ���� ó��
         * */
        if(!ownerRepository.existsById(claims.getSubject())) {
            throw OwnerNotFoundException.EXCEPTION;
        }

        Owner owner = ownerRepository.getReferenceById(claims.getSubject()); // ���̵�� ���� ���

        /**
         * ��й�ȣ�� �´� �� üũ
         * ���� ������ PasswordWrongException ���� ó��
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

        ownerRepository.delete(deleteOwner); // DB�� ����

        return new OwnerDeleteResponse(HttpStatus.OK, "���� ����");
    }
}
