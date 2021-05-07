package com.innovativeapps.filehandling.data.manager;

import com.innovativeapps.filehandling.model.Student;

import javax.ejb.Local;

@Local
public interface StudentDataManagerLocal {

    Student create(Student student);

    void delete(Student student);

    Student getStudentById(String studentId);

}
