package com.innovativeapps.filehandling.util;

import javax.ejb.Stateless;

@Stateless
public class SecretKey {
    private String secret = "ajdkdhfk123";

    public String getSecret() { return secret;}
}
