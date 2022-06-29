package com.project.Dion.domain.owner.service;

import com.project.Dion.domain.owner.presentation.dto.request.OwnerJoinRequest;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerLoginRequest;
import com.project.Dion.domain.owner.presentation.dto.request.OwnerUpdateRequest;
import com.project.Dion.domain.owner.presentation.dto.response.*;

public interface OwnerService {

    OwnerLoginResponse ownerLogin(OwnerLoginRequest ownerLoginRequestDto);

    OwnerJoinResponse ownerJoin(OwnerJoinRequest ownerJoinRequestDto);

    OwnerInfoResponse ownerInfo(String token);

    OwnerUpdateResponse ownerUpdate(String token, OwnerUpdateRequest ownerUpdateRequestDto);

    OwnerDeleteResponse ownerDelete(String token, String pw);

}
