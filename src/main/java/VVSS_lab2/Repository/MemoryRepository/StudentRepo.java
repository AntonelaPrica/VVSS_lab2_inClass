package VVSS_lab2.Repository.MemoryRepository;

import VVSS_lab2.Domain.Student;
import VVSS_lab2.Validator.IValidator;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }
}