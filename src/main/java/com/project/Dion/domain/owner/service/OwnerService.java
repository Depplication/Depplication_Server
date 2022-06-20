package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.dto.request.OwnerDeleteRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerUpdateRequestDto;
import com.project.Dion.domain.owner.entity.Owner;

public interface OwnerService {

    Owner ownerLogin(OwnerLoginRequestDto ownerLoginRequestDto);

    Owner ownerJoin(OwnerJoinRequestDto ownerJoinRequestDto);

    Owner ownerInfo(String token);

    Owner ownerUpdate(String token, OwnerUpdateRequestDto ownerUpdateRequestDto);

    void ownerDelete(String token, OwnerDeleteRequestDto ownerDeleteRequestDto);

}
