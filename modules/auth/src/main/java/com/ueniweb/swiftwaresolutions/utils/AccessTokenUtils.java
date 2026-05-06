package com.ueniweb.swiftwaresolutions.utils;

import com.ueniweb.swiftwaresolutions.properties.AccessTokenProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@RequiredArgsConstructor
public class AccessTokenUtils {
    public static final String USER_ID = "user_id";
    public static final String USER_TYPE = "user_type";

    private final AccessTokenProperties properties;

    public Long fetchUserId(String accessToken){
        try{
            String token = removeBearerPrefix(accessToken);
            byte[] secretKey = decodeSecret(properties.getPassword());
            Integer userId = (Integer) Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token).getBody().get(USER_ID);
            return Long.valueOf(userId.longValue());
        }catch (Exception e){
            return null;
        }
    }

    public String fetchUserType(String accessToken){
        try{
            byte[] secretKey = decodeSecret(properties.getPassword());
            String userType = (String) Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(accessToken).getBody().get(USER_TYPE);
            return userType;
        }catch (Exception e){
            return null;
        }
    }
    private String removeBearerPrefix(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring("Bearer ".length());
        }
        return token;
    }

    public String generateAccessToken(Long userId){
        try {
            byte[] secretKey = decodeSecret(properties.getPassword());
            String jwtToken = Jwts.builder()
                    .claim(USER_ID, userId)
                    .signWith(SignatureAlgorithm.HS256, secretKey).compact();
            return jwtToken;

        } catch (Exception e) {
            return null;
        }
    }

    private byte[] decodeSecret(String key){
        String encodedString = Base64.getEncoder().encodeToString(key.getBytes());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return decodedBytes;
    }

}
