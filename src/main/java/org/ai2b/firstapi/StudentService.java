package org.ai2b.firstapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService (StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    public List<Student> retrieveall() {
        return studentRepository.findAll();
    }

    public Student retrieveById(Integer id) {
        return studentRepository.findById(Math.toIntExact(id)).get();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Integer id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setCourse(updatedStudent.getCourse());
            existingStudent.setContact(updatedStudent.getContact());
            return studentRepository.save(existingStudent);
        } else {
            throw new RuntimeException("Student with ID " + id + " not found");
        }
    }
}
