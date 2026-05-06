package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class PhRouteData {
    private int id;
    private String name;

    PhRouteData(int id,String name){
        this.id = id;
        this.name=name ;
    }
    public static PhRouteData createNewInstance(int id,String name) {
        return new PhRouteData(id, name);
    }
}
