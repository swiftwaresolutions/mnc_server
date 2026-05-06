package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class Patient {

    private final String name;

    private final Long id;

    private final String displayNumber;


    public Patient(Long id,String name, String displayNumber) {
        this.name = name;
        this.displayNumber = displayNumber;
        this.id = id;
    }

    public static Patient newInstance(Long id,String name, String displayNumber) {
        return new Patient(id,name, displayNumber);
    }

}
