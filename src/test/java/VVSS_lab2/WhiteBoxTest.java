package VVSS_lab2;

import VVSS_lab2.Domain.TemaLab;
import VVSS_lab2.Exceptions.ValidatorException;
import VVSS_lab2.Repository.MemoryRepository.TemaLabRepo;
import VVSS_lab2.Validator.TemaLabValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WhiteBoxTest {

    private TemaLabRepo temaLabRepo;
    private TemaLabValidator temaLabValidator;

    @Before
    public void setUp() {
        temaLabValidator = new TemaLabValidator();
        temaLabRepo = new TemaLabRepo(temaLabValidator);
    }

    @Test
    public void addAssignment_TC1() {

        TemaLab temaLab1 = new TemaLab(1, "first homework", 5, 4);
        TemaLab temaLab2 = new TemaLab(1, "second homework", 7, 5);

        try {
            temaLabRepo.save(temaLab1);
            assertEquals(temaLabRepo.size(), 1);

            temaLabRepo.save(temaLab2);
            assertEquals(temaLabRepo.size(), 1); // homework with same id was not added

        } catch (ValidatorException e) {
            fail();
        }
        assertTrue(true);
    }

    @Test
    public void addAssignment_TC2() {
        try {
            temaLabRepo.save(null);
            fail(); // null object should not be added

        } catch (Exception e) {
            assertEquals(temaLabRepo.size(), 0);
            assertEquals(e.getMessage(), "Entity can not be null!\n");
        }
    }

    @Test
    public void addAssignment_TC3() {
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
    public void addAssignment_TC4() {
        TemaLab temaLab = new TemaLab(2, "", 5, 8);
        try {
            temaLabRepo.save(temaLab);
            fail();

        } catch (Exception e) {
            assertEquals(temaLabRepo.size(), 0);
            assertEquals(e.getMessage(), "Descriere tema invalida\n");
        }
    }
}
