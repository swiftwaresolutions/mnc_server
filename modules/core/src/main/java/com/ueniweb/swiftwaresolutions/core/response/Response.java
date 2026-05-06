package com.ueniweb.swiftwaresolutions.core.response;

import lombok.Data;

@Data
public class Response {

    private Long id;

    public Response(final Long id) {
        this.id = id;
    }

    public static Response id(final Long id) {
        return new Response(id);
    }

    public static Response empty() {
        return new Response(null);
    }
}
