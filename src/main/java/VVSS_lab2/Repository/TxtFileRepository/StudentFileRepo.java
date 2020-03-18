package VVSS_lab2.Repository.TxtFileRepository;

import VVSS_lab2.Domain.HasId;
import VVSS_lab2.Domain.Student;
import VVSS_lab2.Repository.TxtFileRepository.AbstractFileRepository;
import VVSS_lab2.Validator.StudentValidator;

import java.io.*;

public class StudentFileRepo extends AbstractFileRepository {
    public StudentFileRepo(String filename, StudentValidator val) throws IOException {
        super(val, filename);
    }


    @Override
    public HasId extractEntity(String[] info) {
        String id = info[0];
        String nume = info[1];
        int grup = Integer.parseInt(info[2]);
        String email = info[3];
        String indrumator = info[4];
        Student s = new Student(id, nume, grup, email, indrumator);
        return s;

    }
}