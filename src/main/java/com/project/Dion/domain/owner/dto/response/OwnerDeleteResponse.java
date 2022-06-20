package com.project.Dion.domain.owner.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OwnerDeleteResponse extends HttpResponse {

    public OwnerDeleteResponse(HttpStatus status, String msg) {
        super(status, msg);
    }
}
