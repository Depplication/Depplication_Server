package com.project.Dion.domain.owner.presentation.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OwnerInfoResponse extends HttpResponse {

    private final String id;
    private final String pw;
    private final String name;
    private final String phone;
    private final String store;
    private final String address;

    public OwnerInfoResponse(HttpStatus status,
                             String msg,
                             String id,
                             String pw,
                             String name,
                             String phone,
                             String store,
                             String address) {
        super(status, msg);
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.phone = phone;
        this.store = store;
        this.address = address;
    }
}
