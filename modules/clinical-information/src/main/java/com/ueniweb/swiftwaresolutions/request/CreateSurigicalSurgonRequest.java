package com.ueniweb.swiftwaresolutions.request;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateSurigicalSurgonRequest {

    private Long id;

    private Long surId;

    private Long surgonId;

    private Long isAssSurgon;

    private Long isValid;

    @Override
    public String toString() {
        return "CreateSurigicalSurgonRequest{" +
                "id=" + id +
                ", surId=" + surId +
                ", surgonId=" + surgonId +
                ", isAssSurgon=" + isAssSurgon +
                ", isAssSurgon=" + isAssSurgon +
                '}';
    }
}
