package VVSS_lab2;

import VVSS_lab2.Domain.Student;
import VVSS_lab2.Exceptions.ValidatorException;
import VVSS_lab2.Repository.MemoryRepository.StudentRepo;
import VVSS_lab2.Validator.StudentValidator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private StudentRepo studentRepo;
    private StudentValidator studentValidator;

    @Test
    public void addStudentTest()
    {
        studentValidator = new StudentValidator();
        studentRepo = new StudentRepo(studentValidator);

        Student student1 = new Student("1","Stud1", 10,"stud1@test.com", "Prof");
        Student student2 = new Student("1","Stud2", 11, "stud2@test.com", "Prof");

        try {
            studentRepo.save(student1);
            assertEquals(studentRepo.size(),1);

            studentRepo.save(student2);
            assertEquals(studentRepo.size(),1); // student with same id was not added

        } catch (ValidatorException e) {
            fail();
        }

        assertTrue( true );
    }
}
