package com.ueniweb.swiftwaresolutions.data;

import lombok.Data;

@Data
public class UserRightsData {

    private Integer id;

    public UserRightsData(final Integer id) {
        this.id = id;
    }

    public static UserRightsData createNewInstance(final Integer id) {
        return new UserRightsData(id);
    }
}
