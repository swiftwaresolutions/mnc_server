package com.ueniweb.swiftwaresolutions.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
@Setter
public class AccessTokenProperties {

    @Value( "${jwt.key.password}" )
    private String password;

}
