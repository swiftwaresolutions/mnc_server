package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class EqualantDrugsData {

    private Integer id;

    private String drugsName;

    public EqualantDrugsData(Integer id,String drugsName) {
        this.id                 = id;
        this.drugsName           = drugsName;

    }

    public static EqualantDrugsData createNewInstance(Integer id,String drugsName) {
        return new EqualantDrugsData(id,drugsName);
    }
}
