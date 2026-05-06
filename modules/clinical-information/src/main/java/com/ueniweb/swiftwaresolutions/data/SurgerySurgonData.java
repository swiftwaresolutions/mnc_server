package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;
@Data
public class SurgerySurgonData {

    private Long id;

    private Long surgonId;

    private Long isAssSurgon;

    private String name;
    public SurgerySurgonData(final Long id,final  Long surgonId,final  Long isAssSurgon,final  String name
    ){
        this.id=id;

        this.surgonId=surgonId;

        this.isAssSurgon=isAssSurgon;

        this.name=name;

    }
    public static SurgerySurgonData createNewInstance(final Long id,final Long surId,final Long surgonId,final  String name) {

        return new SurgerySurgonData( id, surId, surgonId, name);
    }
}
