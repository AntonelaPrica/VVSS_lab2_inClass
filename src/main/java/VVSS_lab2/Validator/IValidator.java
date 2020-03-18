package VVSS_lab2.Validator;

import VVSS_lab2.Exceptions.ValidatorException;

public interface IValidator<E> {
    void validate(E entity) throws ValidatorException;
}