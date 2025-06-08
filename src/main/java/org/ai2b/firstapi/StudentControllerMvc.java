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
        Student student = studentService.retrieveById(id);
        model.addAttribute("student", student);
        return "index";
    }

    @GetMapping("/students")
    public String getAllStudent(Model model) {
        List<Student> studs = studentService.retrieveall();
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


    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


    @GetMapping("/students/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Student student = studentService.retrieveById(id);
        model.addAttribute("student", student);
        return "updateForm";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id") Integer id,
                                @ModelAttribute("student") Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }


}
