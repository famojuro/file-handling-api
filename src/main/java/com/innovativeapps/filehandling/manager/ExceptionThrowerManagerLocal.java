package com.innovativeapps.filehandling.manager;

import com.innovativeapps.filehandling.util.exception.GeneralAppException;

import javax.ejb.Local;

@Local
public interface ExceptionThrowerManagerLocal {

    void throwInvalidTokenException (String link) throws GeneralAppException;

    void throwGeneralException (String link) throws GeneralAppException;

    void throwNullParameterException (String link) throws GeneralAppException;

    void throwInvalidIntegerAttributeException(String link) throws GeneralAppException;

    void throwStudentAlreadyExistException(String link) throws GeneralAppException;
}
