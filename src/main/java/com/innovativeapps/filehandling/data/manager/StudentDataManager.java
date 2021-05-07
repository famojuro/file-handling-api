package com.innovativeapps.filehandling.data.manager;

import com.innovativeapps.filehandling.data.provider.DataProviderLocal;
import com.innovativeapps.filehandling.model.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class StudentDataManager implements StudentDataManagerLocal{
    @EJB
    private DataProviderLocal crud;

    @Override
    public Student create(Student student) { return crud.create(student); }

    @Override
    public void delete(Student student) { crud.delete(student);}

    @Override
    public Student getStudentById(String studentId) { return crud.find(studentId, Student.class); }
}
