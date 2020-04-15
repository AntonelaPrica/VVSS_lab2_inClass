package VVSS_lab2;

import VVSS_lab2.Domain.Nota;
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

import static org.junit.Assert.*;

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
    public void add_TC1() {
        Student student1 = new Student("1", "Stud1", 10, "stud1@test.com", "Prof");
        try {
            studentRepo.save(student1);
            assertEquals(studentRepo.size(), 1);
        } catch (ValidatorException v) {
            fail();
        }
    }

    @Test
    public void add_TC2() {
        TemaLab temaLab1 = new TemaLab(1, "first homework", 5, 4);
        try {
            temaLabRepo.save(temaLab1);
            assertEquals(temaLabRepo.size(), 1);
        } catch (ValidatorException v) {
            fail();
        }
    }

    @Test
    public void add_TC3() {
        Nota nota = new Nota(1, "1", 1, 10);
        try {
            notaRepo.save(nota);
            assertEquals(notaRepo.size(), 1);
        } catch (ValidatorException v) {
            fail();
        }
    }

    @Test
    public void add_TC4() {
        add_TC1();
        add_TC2();
        add_TC3();
    }

    @Test
    public void incr_TC_addStud() {
        studentRepo = new StudentRepo(studentValidator);
        Student stud = new Student("1", "Rus Mihai", 1, "rm@yahoo.com", "Prof. Maria");
        try {
            studentRepo.save(stud);
        } catch (ValidatorException e) {
            assertEquals(studentRepo.size(), 0);
        }
        assertEquals(studentRepo.size(), 1);
    }

    @Test
    public void incr_TC_addAssign() {

        incr_TC_addStud(); // test add student
        temaLabRepo = new TemaLabRepo(temaLabValidator);
        TemaLab temaLab = new TemaLab(1, "Lab Homework", 8, 7);
        try {
            TemaLab prevValue = temaLabRepo.save(temaLab);
            assertEquals(temaLabRepo.size(), 1);
            assertNull(prevValue);

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void incr_TC_addGrade() {

        incr_TC_addStud(); // test add student
        add_TC2(); //  test add assignment

        notaRepo = new NotaRepo(notaValidator);
        Nota nota = new Nota(1, "1", 1, 10);
        try {
            notaRepo.save(nota);
            assertEquals(notaRepo.size(), 1);
        } catch (ValidatorException v) {
            fail();
        }
    }

}
