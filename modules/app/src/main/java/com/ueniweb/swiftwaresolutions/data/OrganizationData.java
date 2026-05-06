package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class OrganizationData {

    private final String name;

    private final String code;

    private final int port;

    private final Integer salesStoreId;

    public OrganizationData(String name, String code,int port,Integer salesStoreId) {
        this.name           = name;
        this.code           = code;
        this.port = port;
        this.salesStoreId   = salesStoreId;
    }

    public static OrganizationData newInstance(String name, String code, int port,Integer salesStoreId) {
        return new OrganizationData(name, code, port,salesStoreId);
    }

}
