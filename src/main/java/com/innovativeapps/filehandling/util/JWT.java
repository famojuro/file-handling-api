package com.innovativeapps.filehandling.util;

import com.innovativeapps.filehandling.util.exception.GeneralAppException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

public class JWT {
    SecretKey secretKey = new SecretKey();

    public Claims parseJWT(String jwt) {

        Claims claims = Jwts.parser()
            .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey.getSecret()))
            .parseClaimsJws(jwt).getBody();

        return claims;
    }

    public Claims verifyJwt(String rawToken, String resource) throws GeneralAppException {
        try {
            String authToken = rawToken.substring(7);
            return parseJWT(authToken);
        }  catch (Exception e) {
            throw new GeneralAppException(Response.Status.BAD_REQUEST.getStatusCode(),
                    400, "Invalid token supplied", "Token supplied could not be parsed",
                    resource);
        }
    }
}
