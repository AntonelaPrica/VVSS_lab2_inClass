package VVSS_lab2;

import VVSS_lab2.Domain.Student;
import VVSS_lab2.Exceptions.ValidatorException;
import VVSS_lab2.Repository.MemoryRepository.StudentRepo;
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
    }
    @Test
    public void addStudent_TC11() {
    }
    @Test
    public void addStudent_TC12() {
    }
    @Test
    public void addStudent_TC13() {
    }
    @Test
    public void addStudent_TC14() {
    }
    @Test
    public void addStudent_TC15() {
    }
    @Test
    public void addStudent_TC16() {
    }
    @Test
    public void addStudent_TC17() {
    }
}
