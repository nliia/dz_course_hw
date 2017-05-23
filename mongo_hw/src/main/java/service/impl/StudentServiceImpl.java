package service.impl;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import service.StudentService;

import java.math.BigInteger;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getUserById(BigInteger id) {
        return studentRepository.findOne(id);
    }

    public void deleteMinScore() {

        List<Student> students = studentRepository.findAll();
        students.forEach(student -> student.getScores().remove(
                student.getScores().stream().min((o1, o2) -> o1.getScore().compareTo(o2.getScore())).orElse(null)
        ));
        studentRepository.save(students);
    }

}
