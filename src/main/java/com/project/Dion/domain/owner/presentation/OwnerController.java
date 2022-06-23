package com.project.Dion.domain.owner.presentation;

import com.project.Dion.domain.owner.presentation.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerUpdateRequestDto;
import com.project.Dion.domain.owner.presentation.dto.response.*;
import com.project.Dion.domain.owner.service.OwnerServiceImpl;
import com.project.Dion.global.token.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerServiceImpl service;
    private final TokenService tService;

    @PostMapping("/join")
    public OwnerJoinResponse ownerJoin(
            @RequestBody OwnerJoinRequestDto dto
    ) {
        return service.ownerJoin(dto);
    }

    @PostMapping("login")
    public OwnerLoginResponse ownerLogin(
            @RequestBody OwnerLoginRequestDto dto
    ) {
        return service.ownerLogin(dto);
    }

    @GetMapping("/info")
    public OwnerInfoResponse ownerInfo(
            @RequestHeader String authorization
    ) {
        return service.ownerInfo(authorization);
    }

    @PatchMapping("/update")
    public OwnerUpdateResponse ownerUpdate(
            @RequestHeader String authorization,
            @RequestBody OwnerUpdateRequestDto dto
    ) {
        return service.ownerUpdate(authorization, dto);
    }

    @DeleteMapping("/delete")
    public OwnerDeleteResponse ownerDelete(
            @RequestHeader String authorization,
            @PathVariable String pw
    ) {
        return service.ownerDelete(authorization, pw);
    }
}
