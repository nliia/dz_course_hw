package service;

import model.Student;

import java.math.BigInteger;

public interface StudentService {

    Student getUserById(BigInteger id);

    void deleteMinScore();
}
