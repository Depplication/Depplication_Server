package com.project.Dion.domain.owner.presentation.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OwnerJoinResponse extends HttpResponse {

    public OwnerJoinResponse(HttpStatus status, String msg) {
        super(status, msg);
    }

}
