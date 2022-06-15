package com.project.Dion.domain.owner.controller;

import com.project.Dion.domain.owner.dto.request.OwnerInfoRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.dto.response.OwnerInfoResponse;
import com.project.Dion.domain.owner.dto.response.OwnerJoinResponse;
import com.project.Dion.domain.owner.dto.response.OwnerLoginResponse;
import com.project.Dion.domain.owner.entity.Owner;
import com.project.Dion.domain.owner.service.OwnerServiceImpl;
import com.project.Dion.global.token.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerServiceImpl service;
    private final TokenService tService;

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public OwnerJoinResponse<Owner> ownerJoin(
            @RequestBody OwnerJoinRequestDto dto
    ) {

        Owner join = service.ownerJoin(dto);

        return new OwnerJoinResponse<Owner>(HttpStatus.OK, "회원가입 성공", join);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public OwnerLoginResponse<Owner> ownerLogin(
            @RequestBody OwnerLoginRequestDto dto
    ) {
        Owner login = service.ownerLogin(dto);

        return new OwnerLoginResponse<Owner>(HttpStatus.OK, "로그인 성공", login, tService.createToken(dto.getId()));
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public OwnerInfoResponse<Owner> ownerInfo(
            @RequestBody OwnerInfoRequestDto dto
    ) {
        Owner info = service.ownerInfo(dto);

        return new OwnerInfoResponse<Owner>(HttpStatus.OK, "업주정보 불러오기 성공", info);
    }
}
