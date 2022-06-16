package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.dto.request.OwnerInfoRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.entity.Owner;

public interface OwnerService {

    Owner ownerLogin(OwnerLoginRequestDto ownerLoginRequestDto);

    Owner ownerJoin(OwnerJoinRequestDto ownerJoinRequestDto);

    Owner ownerInfo(OwnerInfoRequestDto ownerInfoRequestDto);

}
