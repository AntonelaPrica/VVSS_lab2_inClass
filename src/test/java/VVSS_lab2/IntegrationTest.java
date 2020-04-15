package VVSS_lab2;

import VVSS_lab2.Domain.Student;
import VVSS_lab2.Domain.TemaLab;
import VVSS_lab2.Exceptions.ValidatorException;
import VVSS_lab2.Repository.MemoryRepository.NotaRepo;
import VVSS_lab2.Repository.MemoryRepository.StudentRepo;
import VVSS_lab2.Repository.MemoryRepository.TemaLabRepo;
import VVSS_lab2.Repository.TxtFileRepository.StudentFileRepo;
import VVSS_lab2.Validator.NotaValidator;
import VVSS_lab2.Validator.StudentValidator;
import VVSS_lab2.Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IntegrationTest {

    private StudentRepo studentRepo;
    private StudentValidator studentValidator;

    private TemaLabRepo temaLabRepo;
    private TemaLabValidator temaLabValidator;

    private NotaRepo notaRepo;
    private NotaValidator notaValidator;

    @Before
    public void setUp() {
        studentValidator = new StudentValidator();
        studentRepo = new StudentRepo(studentValidator);

        temaLabValidator = new TemaLabValidator();
        temaLabRepo = new TemaLabRepo(temaLabValidator);

        notaValidator = new NotaValidator();
        notaRepo = new NotaRepo(notaValidator);
    }

    @Test
    public void add_TC1()
    {
        Student student1 = new Student("1", "Stud1", 10, "stud1@test.com", "Prof");
        try {
            studentRepo.save(student1);
            assertEquals(studentRepo.size(), 1);
        }catch (ValidatorException v)
        {
            fail();
        }
    }

    @Test
    public void add_TC2()
    {
        TemaLab temaLab1 = new TemaLab(1, "first homework", 5, 4);
        try {
            temaLabRepo.save(temaLab1);
            assertEquals(temaLabRepo.size(), 1);
        }catch (ValidatorException v)
        {
            fail();
        }
    }

    @Test
    public void add_TC3()
    {

    }

    @Test
    public void add_TC4()
    {

    }
}
