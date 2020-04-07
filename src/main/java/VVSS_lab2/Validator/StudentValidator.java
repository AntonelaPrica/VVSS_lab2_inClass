package VVSS_lab2.Validator;


import VVSS_lab2.Domain.Student;
import VVSS_lab2.Exceptions.ValidatorException;

public class StudentValidator implements IValidator<Student> {

    public void validate(Student s) throws ValidatorException {
        String errors="";
        if(s.getId().equals("")){
            //throw new ValidatorException("Id invalid\n");
            errors+="Id invalid\n";
        }

        if( s.getNume()==null || s.getNume().equals("") ){
            //throw new ValidatorException("Nume invalid\n");
            errors+="Nume invalid\n";
        } else {
            // Name cannot be a number
            try {
                Integer.parseInt(s.getNume());
                errors += "Nume invalid\n";
            } catch (NumberFormatException ignored) {
            }
        }

        if(s.getGrupa()<=0){
            //throw new ValidatorException("Grupa invalida\n");
            errors+="Grupa invalid\n";
        }

        // Check also email format
        if(s.getEmail()==null  || s.getEmail().equals("") || !s.getEmail().matches("[a-z0-9]*@[a-z0-9]*\\.[a-z]*")){
            //throw new ValidatorException("Email invalid\n");
            errors+="Email invalid\n";
        } else {
            // Email cannot be a number
            try {
                Integer.parseInt(s.getEmail());
                errors += "Email invalid\n";
            } catch (NumberFormatException ignored) {
            }
        }

        if(s.getIndrumator() == null || s.getIndrumator().equals("") )
        {
            errors+="Indrumator invalid\n";
        } else{
            // Coordinator cannot be a number
            try {
                Integer.parseInt(s.getIndrumator());
                errors += "Indrumator invalid\n";
            } catch (NumberFormatException ignored) {
            }
        }

        if (errors.length()!=0){
            throw  new ValidatorException(errors);
        }
    }
}