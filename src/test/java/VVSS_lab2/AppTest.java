package VVSS_lab2;

import VVSS_lab2.Domain.Student;
import VVSS_lab2.Domain.TemaLab;
import VVSS_lab2.Exceptions.ValidatorException;
import VVSS_lab2.Repository.MemoryRepository.StudentRepo;
import VVSS_lab2.Repository.MemoryRepository.TemaLabRepo;
import VVSS_lab2.Service.TxtFileService.StudentService;
import VVSS_lab2.Validator.StudentValidator;
import VVSS_lab2.Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import javax.xml.validation.Validator;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    private StudentRepo studentRepo;
    private StudentValidator studentValidator;
    
    private TemaLabRepo temaLabRepo;
    private TemaLabValidator temaLabValidator;

    @Before
    public void setUp()
    {
        studentValidator = new StudentValidator();
        studentRepo = new StudentRepo(studentValidator);

        temaLabValidator = new TemaLabValidator();
        temaLabRepo = new TemaLabRepo(temaLabValidator);
    }

//    @Test
//    public void addStudentTest() {
//
//        Student student1 = new Student("1", "Stud1", 10, "stud1@test.com", "Prof");
//        Student student2 = new Student("1", "Stud2", 11, "stud2@test.com", "Prof");
//
//        try {
//            studentRepo.save(student1);
//            assertEquals(studentRepo.size(), 1);
//
//            studentRepo.save(student2);
//            assertEquals(studentRepo.size(), 1); // student with same id was not added
//
//        } catch (ValidatorException e) {
//            fail();
//        }
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void addStudentTest2() {
//
//        Student student = new Student("", "Stud1", 10, "stud1@test.com", "Prof");
//        try {
//            studentRepo.save(student);
//            // if error was not thrown => is not correct since id is empty
//            fail();
//        } catch (ValidatorException e) {
//            // student with empty id should not be added
//            assertEquals(studentRepo.size(), 0);
//        }
//    }

    @Test
    public void addStudent_TC1() {
        Student stud = new Student("1", "Rus Mihai", 1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
        } catch (ValidatorException e) {
            assertEquals(studentRepo.size(), 0);
        }
        assertEquals(studentRepo.size(), 1);
    }

    @Test
    public void addStudent_TC2() {
        Student stud = new Student("1", "Rus Mihai", 1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            if (!(stud.getNume() instanceof String))
                assertEquals(studentRepo.size(), 0);

        } catch (ValidatorException e) {
            assertEquals(studentRepo.size(), 0);
        }
        assertEquals(studentRepo.size(), 1);
    }

    @Test
    public void addStudent_TC3() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            studentRepo.save(stud);
            fail();
        } catch (Exception e) {
            assertEquals(studentRepo.size(), 1);
        }
    }

    @Test
    public void addStudent_TC4() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("", "Rus Mihai", 1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the id cannot be empty
            fail();
        } catch (ValidatorException e) {
            // student with no id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC5() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "8", 1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the name cannot be a number
            fail();
        } catch (Exception e) {
            // student with no valid name should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC6() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "", 1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the name cannot be empty
            fail();
        } catch (ValidatorException e) {
            // student with no name should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC7() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", null, 1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the name cannot be null
            fail();
        } catch (Exception e) {
            // student with no name should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC8() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", -1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the group cannot be less than 0
            fail();
        } catch (ValidatorException e) {
            // student with group less than 0 should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC9() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 0, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the group cannot be 0
            fail();
        } catch (ValidatorException e) {
            // student with group 0 should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC10() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 936, "2", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the email does not have the type string
            fail();
        } catch (ValidatorException e) {
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }
    @Test
    public void addStudent_TC11() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 936, "rm@yahoo.com", "Prof. Maria");
        Student stud_new = new Student("2", "Rus Maria", 936, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
            studentRepo.save(stud_new);
            // if error was not thrown => is not correct since the email already exists
            fail();
        } catch (ValidatorException e) {
            // second student with the same email should not be added
            assertEquals(studentRepo.size(), 1);
        }
    }
    @Test
    public void addStudent_TC12() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 936, "", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the email is empty
            fail();
        } catch (ValidatorException e) {
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }
    @Test
    public void addStudent_TC13() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 936, "email", "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the email does not have the right format: a-z@a-z.a-z
            fail();
        } catch (ValidatorException | NullPointerException e) {
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }
    @Test
    public void addStudent_TC14() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 936, null, "Prof. Maria");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the email is null
            fail();
        } catch (ValidatorException | NullPointerException e) {
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }
    @Test
    public void addStudent_TC15() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 936, "email@yahoo.com", "123");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the coordinator type is integer not string
            fail();
        } catch (ValidatorException e) {
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC16() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 936, "email@yahoo.com", "");
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since the coordinator is empty
            fail();
        } catch (ValidatorException e) {
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC17() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 936, "email@yahoo.com", null);
        try {
            studentRepo.save(stud);
            // if error was not thrown => is not correct since coordinator is null
            fail();
        } catch (ValidatorException e) {
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

}
