package com.innovativeapps.filehandling.manager;

import com.innovativeapps.filehandling.util.exception.GeneralAppException;

import javax.ejb.Stateless;

@Stateless
public class ExceptionThrowerManager implements ExceptionThrowerManagerLocal {

    private final String STUDENT_WITH_ID_EXIST = "student with ID already exist";

    @Override
    public void throwInvalidTokenException(String link) throws GeneralAppException {

    }

    @Override
    public void throwGeneralException(String link) throws GeneralAppException {

    }

    @Override
    public void throwNullParameterException(String link) throws GeneralAppException {

    }

    @Override
    public void throwInvalidIntegerAttributeException(String link) throws GeneralAppException {

    }

    @Override
    public void throwStudentAlreadyExistException(String link) throws GeneralAppException {
        throw new GeneralAppException(201,
                400, STUDENT_WITH_ID_EXIST, STUDENT_WITH_ID_EXIST, link);

    }
}
