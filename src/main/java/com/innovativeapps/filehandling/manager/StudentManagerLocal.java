package com.innovativeapps.filehandling.manager;

import com.innovativeapps.filehandling.pojo.AppStudent;
import com.innovativeapps.filehandling.util.exception.GeneralAppException;

import javax.ejb.Local;
import java.io.File;

@Local
public interface StudentManagerLocal {

    AppStudent createStudent(String id, String name, String city, File fileMapped) throws GeneralAppException;
}
