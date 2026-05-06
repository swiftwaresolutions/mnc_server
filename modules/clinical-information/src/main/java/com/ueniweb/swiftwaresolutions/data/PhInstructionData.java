package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class PhInstructionData {

    private int id;
    private String name;

    public PhInstructionData(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static PhInstructionData createNewInstruction(int id,String name){
        return new PhInstructionData(id,name);
    }
}
