package com.project.Dion.domain.owner.controller;

import com.project.Dion.domain.owner.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.dto.response.OwnerJoinResponse;
import com.project.Dion.domain.owner.entity.Owner;
import com.project.Dion.domain.owner.service.OwnerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerServiceImpl service;

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public OwnerJoinResponse<Owner> ownerJoin(
            @RequestBody OwnerJoinRequestDto dto
    ) {

        Owner join = service.ownerJoin(dto);

        return new OwnerJoinResponse<Owner>(HttpStatus.OK, "회원가입 성공", join);
    }

}
