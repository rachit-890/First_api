package org.ai2b.firstapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        super();
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.retriveall();

    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.retriveById(id);
    }
    @PostMapping("/students/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id){
         studentService.deleteStudent(id);
    }
}
