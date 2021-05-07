package com.innovativeapps.filehandling.manager;

import com.innovativeapps.filehandling.data.manager.StudentDataManagerLocal;
import com.innovativeapps.filehandling.model.Student;
import com.innovativeapps.filehandling.pojo.AppStudent;
import com.innovativeapps.filehandling.util.Verifier;
import com.innovativeapps.filehandling.util.exception.GeneralAppException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Stateless
public class StudentManager implements StudentManagerLocal {

    @EJB
    private StudentDataManagerLocal dataManager;

    @EJB
    private ExceptionThrowerManagerLocal exceptionManager;

    @EJB
    private Verifier verifier;

    private String filePath = "/home/famojuro/student-uploads/";
    String STUDENT_LINK = "/student";

    @Override
    public AppStudent createStudent(String id, String name, String city, File file) throws GeneralAppException {
        verifier.setResourceUrl(STUDENT_LINK)
                .verifyParams(id, name, city, file.getName());

        Student student = new Student();

        Student checkId = dataManager.getStudentById(id);

        if (checkId != null) {
            exceptionManager.throwStudentAlreadyExistException(STUDENT_LINK);
        }

        student.setName(name);
        student.setCity(city);
        StringBuilder fileNames = new StringBuilder();
        String fileName = id + file.getName().substring(file.getName().length()-4);
        Path fileNameAndPath = Paths.get(filePath, fileName);
        file = new File(String.valueOf(fileNameAndPath));
        student.setImage(fileName);

        student = dataManager.create(student);

        AppStudent appStudent = new AppStudent();
        appStudent.setId(student.getId());
        appStudent.setName(student.getName());
        appStudent.setImage(student.getImage());

        return appStudent;
    }
}
