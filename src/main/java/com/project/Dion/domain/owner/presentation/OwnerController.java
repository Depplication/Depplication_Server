package com.project.Dion.domain.owner.presentation;

import com.project.Dion.domain.owner.presentation.dto.request.OwnerJoinRequest;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerLoginRequest;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerUpdateRequest;
import com.project.Dion.domain.owner.presentation.dto.response.*;
import com.project.Dion.domain.owner.service.OwnerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerServiceImpl service;

    /**
     * 회원가입
     *
     * URL = /owner/join
     * Method = post
     * RequestBody = OwnerJoinRequest
     * Response = OwnerJoinResponse
     * */
    @PostMapping("/join")
    public OwnerJoinResponse ownerJoin(
            @RequestBody OwnerJoinRequest dto
    ){
        return service.ownerJoin(dto);
    }

    /**
     * 로그인
     *
     * URL = /owner/login
     * Method = post
     * RequestBody = OwnerLoginRequest
     * Response = OwnerLoginResponse
     * */
    @PostMapping("login")
    public OwnerLoginResponse ownerLogin(
            @RequestBody OwnerLoginRequest dto
    ) {
        return service.ownerLogin(dto);
    }

    /**
     * 정보 불러오기
     *
     * URL = /owner/info
     * Method = get
     * RequestHeader = authorization
     * Response = OwnerJoinResponse
     * */
    @GetMapping("/info")
    public OwnerInfoResponse ownerInfo(
            @RequestHeader String authorization
    ) {
        return service.ownerInfo(authorization);
    }

    /**
     * 업데이트
     *
     * URL = /owner/update
     * Method = patch
     * RequestHeader = authorization
     * RequestBody = OwnerUpdateRequest
     * Response = OwnerUpdateResponse
     * */
    @PatchMapping("/update")
    public OwnerUpdateResponse ownerUpdate(
            @RequestHeader String authorization,
            @RequestBody OwnerUpdateRequest dto
    ) {
        return service.ownerUpdate(authorization, dto);
    }

    /**
     * 삭제
     *
     * URL = /owner/delete
     * Method = delete
     * RequestHeader = authorization
     * PathVariable = pw
     * Response = OwnerDeleteResponse
     * */
    @DeleteMapping("/delete")
    public OwnerDeleteResponse ownerDelete(
            @RequestHeader String authorization,
            @PathVariable String pw
    ) {
        return service.ownerDelete(authorization, pw);
    }
}
