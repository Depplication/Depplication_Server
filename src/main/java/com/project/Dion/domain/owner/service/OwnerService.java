package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.presentation.dto.request.OwnerJoinRequestDto;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerLoginRequestDto;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerUpdateRequestDto;
import com.project.Dion.domain.owner.presentation.dto.response.*;

public interface OwnerService {

    OwnerLoginResponse ownerLogin(OwnerLoginRequestDto ownerLoginRequestDto);

    OwnerJoinResponse ownerJoin(OwnerJoinRequestDto ownerJoinRequestDto);

    OwnerInfoResponse ownerInfo(String token);

    OwnerUpdateResponse ownerUpdate(String token, OwnerUpdateRequestDto ownerUpdateRequestDto);

    OwnerDeleteResponse ownerDelete(String token, String pw);

}
