package org.ai2b.firstapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService (StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    public List<Student> retriveall() {
        return studentRepository.findAll();
    }

    public Student retriveById(Integer id) {
        return studentRepository.findById(Math.toIntExact(id)).get();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
