package repository;

import model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface StudentRepository extends MongoRepository<Student, BigInteger> {
}
