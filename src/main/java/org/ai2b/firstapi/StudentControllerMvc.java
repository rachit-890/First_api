package org.ai2b.firstapi;

import jakarta.persistence.PostUpdate;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentControllerMvc {
    private final StudentService studentService;

    public StudentControllerMvc(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}")
    public String getStudents( Model model,@PathVariable Integer id) {
        Student student = studentService.retriveById(id);
        model.addAttribute("student", student);
        return "index";
    }

    @GetMapping("/students")
    public String getAllStudent(Model model) {
        List<Student> studs = studentService.retriveall();
        model.addAttribute("students", studs);
        return "demo";
    }

    @GetMapping("/students/add")
    public String addStudent(Model model) {
        model.addAttribute("student",new Student());
        return "modelPage";
    }

    @PostMapping("/student/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }


    @PostMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
