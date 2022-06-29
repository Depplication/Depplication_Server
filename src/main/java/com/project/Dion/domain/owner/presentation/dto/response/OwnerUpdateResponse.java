package com.project.Dion.domain.owner.presentation.dto.response;

import com.project.Dion.global.response.HttpResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OwnerUpdateResponse extends HttpResponse {

    private String id;
    private String name;
    private String phone;
    private String store;
    private String address;

    public OwnerUpdateResponse(HttpStatus status,
                               String msg,
                               String id,
                               String name,
                               String phone,
                               String store,
                               String address) {
        super(status, msg);
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.store = store;
        this.address = address;
    }
}
