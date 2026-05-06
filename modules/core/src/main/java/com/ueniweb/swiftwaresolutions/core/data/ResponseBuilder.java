package com.ueniweb.swiftwaresolutions.core.data;


import com.ueniweb.swiftwaresolutions.core.response.Response;
import lombok.Data;

@Data
public class ResponseBuilder {

    private Long id;

    public Response build() {
        return new Response(id);
    }

    public ResponseBuilder withEntityId(Long id) {
        this.id = id;
        return this;
    }
}
