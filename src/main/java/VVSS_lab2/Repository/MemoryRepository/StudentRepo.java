package VVSS_lab2.Repository.MemoryRepository;

import VVSS_lab2.Domain.Student;
import VVSS_lab2.Exceptions.ValidatorException;
import VVSS_lab2.Validator.IValidator;

import java.util.Map;
import java.util.Optional;

public class StudentRepo extends AbstractCrudRepo<String, Student> {
    public StudentRepo(IValidator<Student> v){ super(v);
    }

    @Override
    public Student save(Student entity) throws ValidatorException {
        Optional<Map.Entry<String, Student>> any = super.entityes.entrySet().stream().filter(v -> v.getValue().getEmail().equals(entity.getEmail())).findAny();
        if(any.isPresent())
            throw new ValidatorException("Un student cu acelasi email exista deja\n");
        return super.save(entity);
    }
}