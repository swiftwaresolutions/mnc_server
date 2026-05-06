package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class ClinicalModData {

    private final String group;

    private final String menuName;

    private final String dispName;

    private final String menuCode;

    public ClinicalModData(String group, String menuName,String dispName,String menuCode) {
        this.group      = group;
        this.menuName   = menuName;
        this.dispName   = dispName;
        this.menuCode   = menuCode;
    }

    public static ClinicalModData newInstance(String group, String menuName,String dispName,String menuCode) {
        return new ClinicalModData(group,menuName,dispName,menuCode);
    }
}
