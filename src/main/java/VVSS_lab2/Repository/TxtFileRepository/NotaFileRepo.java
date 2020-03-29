package VVSS_lab2.Repository.TxtFileRepository;

import VVSS_lab2.Domain.HasId;
import VVSS_lab2.Domain.Nota;
import VVSS_lab2.Validator.NotaValidator;

import java.io.*;
import java.time.LocalDateTime;

public class NotaFileRepo extends AbstractFileRepository {
    public NotaFileRepo(String filename, NotaValidator val) throws IOException {
        super(val, filename);
    }

    @Override
    public HasId extractEntity(String[] info) {
        Integer idNota = Integer.parseInt(info[0]);
        String idStudent = info[1];
        Integer idTema = Integer.parseInt(info[2]);
        double valoare = Double.parseDouble(info[3]);
        //TemaLab t=findOne(idTema);
        LocalDateTime ldt=LocalDateTime.parse(info[4]);
        Nota n = new Nota(idNota, idStudent, idTema, valoare);
        return n;
    }


}