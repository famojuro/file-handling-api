package com.innovativeapps.filehandling.util;

import com.innovativeapps.filehandling.manager.ExceptionThrowerManagerLocal;
import com.innovativeapps.filehandling.util.exception.GeneralAppException;
import io.jsonwebtoken.Claims;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class Verifier {

    @EJB
    private ExceptionThrowerManagerLocal exceptionManager;

    private String resourceUrl;

    public Verifier setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
        return this;
    }

    public void verifyParams(String... params) throws GeneralAppException {
        for (String param : params) {
            if (param == null || param.isEmpty()) {
                throwNullParameterException(resourceUrl);
            }
        }
    }

    public void verifyInteger(String... params) throws GeneralAppException {
        for (String param : params) {
            try {
                Integer.parseInt(param);
            } catch (Exception e) {
                exceptionManager.throwInvalidIntegerAttributeException(resourceUrl);
            }
        }
    }

    public Claims verifyJwt(String rawToken)
            throws GeneralAppException {
        try {
            String authToken = rawToken.substring(7);
            JWT  token = new JWT();
            return token.parseJWT(authToken);
        }  catch (Exception e) {
            System.out.println("TOKEN EXCEPTION: " + e.getMessage());
            exceptionManager.throwInvalidTokenException(resourceUrl);
        }
        return null;
    }

    private void throwNullParameterException(String link)
            throws GeneralAppException {
        exceptionManager.throwNullParameterException(link);
    }

}
