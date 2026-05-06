package com.ueniweb.swiftwaresolutions.request;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class CreateSurgicalSurgeryRequest {

    private Long id;

    private Long surId;

    private String surgeryName;

    private Long isValid;

    @Override
    public String toString() {
        return "CreateSurgicalSurgeryRequest{" +
                "id=" + id +
                ", surId=" + surId +
                ", surgeryName='" + surgeryName + '\'' +
                ", isValid=" + isValid +
                '}';
    }

}
