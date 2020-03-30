package VVSS_lab2;

import VVSS_lab2.Domain.Student;
import VVSS_lab2.Exceptions.ValidatorException;
import VVSS_lab2.Repository.MemoryRepository.StudentRepo;
import VVSS_lab2.Service.TxtFileService.StudentService;
import VVSS_lab2.Validator.StudentValidator;
import org.junit.Before;
import org.junit.Test;

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

    private StudentService studentService;

    @Before
    public void setUp()
    {
        studentValidator = new StudentValidator();
        studentRepo = new StudentRepo(studentValidator);
    }

    @Test
    public void addStudentTest() {

        Student student1 = new Student("1", "Stud1", 10, "stud1@test.com", "Prof");
        Student student2 = new Student("1", "Stud2", 11, "stud2@test.com", "Prof");

        try {
            studentRepo.save(student1);
            assertEquals(studentRepo.size(), 1);

            studentRepo.save(student2);
            assertEquals(studentRepo.size(), 1); // student with same id was not added

        } catch (ValidatorException e) {
            fail();
        }

        assertTrue(true);
    }

    @Test
    public void addStudentTest2() {

        Student student = new Student("", "Stud1", 10, "stud1@test.com", "Prof");
        try {
            studentRepo.save(student);
            // if error was not thrown => is not correct since id is empty
            fail();
        } catch (ValidatorException e) {
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
        }
    }

    @Test
    public void addStudent_TC1() {
        Student stud = new Student("1", "Rus Mihai", 936, "email@yahoo.com", "Pop Maria");
        try {
            studentRepo.save(stud);
        } catch (ValidatorException e) {
            assertEquals(studentRepo.size(), 0);
        }
        assertEquals(studentRepo.size(), 1);
    }

    @Test
    public void addStudent_TC2() {
        int studentId = 2;
        Student stud = new Student();
    }

    @Test
    public void addStudent_TC3() {
    }

    @Test
    public void addStudent_TC4() {
    }

    @Test
    public void addStudent_TC5() {
    }

    @Test
    public void addStudent_TC6() {
    }

    @Test
    public void addStudent_TC7() {
    }

    @Test
    public void addStudent_TC8() {
    }

    @Test
    public void addStudent_TC9() {
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
            // student with empty id should not be added
            assertEquals(studentRepo.size(), 0);
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
