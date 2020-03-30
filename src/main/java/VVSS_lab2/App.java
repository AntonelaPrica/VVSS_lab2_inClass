package VVSS_lab2;

import VVSS_lab2.Exceptions.ValidatorException;
import VVSS_lab2.Repository.XMLFileRepository.NotaXMLRepo;
import VVSS_lab2.Repository.XMLFileRepository.StudentXMLRepo;
import VVSS_lab2.Repository.XMLFileRepository.TemaLabXMLRepo;
import VVSS_lab2.Service.XMLFileService.NotaXMLService;
import VVSS_lab2.Service.XMLFileService.StudentXMLService;
import VVSS_lab2.Service.XMLFileService.TemaLabXMLService;
import VVSS_lab2.UI.ui;
import VVSS_lab2.Validator.NotaValidator;
import VVSS_lab2.Validator.StudentValidator;
import VVSS_lab2.Validator.TemaLabValidator;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException, ValidatorException {
        //System.out.println("Hello World!");
        StudentValidator vs=new StudentValidator();
        TemaLabValidator vt=new TemaLabValidator();
        NotaValidator vn=new NotaValidator();
        StudentXMLRepo strepo=new StudentXMLRepo(vs,"StudentiXML.xml");
        TemaLabXMLRepo tmrepo=new TemaLabXMLRepo(vt,"TemaLaboratorXML.xml");
        NotaXMLRepo ntrepo=new NotaXMLRepo(vn,"NotaXML.xml");
        StudentXMLService stsrv=new StudentXMLService(strepo);
        TemaLabXMLService tmsrv=new TemaLabXMLService(tmrepo);
        NotaXMLService ntsrv=new NotaXMLService(ntrepo);
        ui ui=new ui(stsrv,tmsrv,ntsrv);
        ui.run();
    }
}
