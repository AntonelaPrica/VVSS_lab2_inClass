package VVSS_lab2.Service.TxtFileService;


import VVSS_lab2.Domain.Nota;
import VVSS_lab2.Repository.TxtFileRepository.NotaFileRepo;

public class NotaService extends AbstractService<Integer, Nota> {
    public NotaService(NotaFileRepo notaRepo){
        super(notaRepo);
    }
}
