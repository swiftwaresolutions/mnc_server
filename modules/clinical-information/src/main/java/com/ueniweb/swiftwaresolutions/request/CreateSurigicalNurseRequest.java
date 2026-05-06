package com.ueniweb.swiftwaresolutions.request;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateSurigicalNurseRequest {

    private Long id;

    private Long surId;

    private String nurse;

    private Long isAssNurse;

    private Long isValid;

    @Override
    public String toString() {
        return "CreateSurigicalNurseRequest{" +
                "id=" + id +
                ", surId=" + surId +
                ", nurse=" + nurse +
                ", isAssNurse=" + isAssNurse +
                ", isValid=" + isValid +
                '}';
    }
}
