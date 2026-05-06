package com.ueniweb.swiftwaresolutions.data;

import com.ueniweb.swiftwaresolutions.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUser {

    private Long id;

    private User user;

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
