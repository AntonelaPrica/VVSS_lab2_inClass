package VVSS_lab2.Repository.MemoryRepository;


import VVSS_lab2.Domain.Nota;
import VVSS_lab2.Validator.IValidator;

public class NotaRepo extends AbstractCrudRepo<Integer, Nota> {
    public NotaRepo(IValidator<Nota> v){ super(v);
    }
}