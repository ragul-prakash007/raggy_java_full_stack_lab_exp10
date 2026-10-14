
package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students",
                studentService.getAllStudents());
        model.addAttribute("searched", false);
        return "student-list";
    }

    @GetMapping("/search")
    public String searchStudent(
            @RequestParam("regno") int regno, Model model) {

        Optional<Student> result =
                studentService.getStudentByRegno(regno);

        List<Student> students =
                result.map(List::of).orElseGet(List::of);

        model.addAttribute("students", students);
        model.addAttribute("searched", true);

        return "student-list";
    }

    @GetMapping("/edit/{regno}")
    public String editStudent(
            @PathVariable("regno") int regno, Model model) {

        Optional<Student> result =
                studentService.getStudentByRegno(regno);

        if (result.isEmpty()) {
            return "redirect:/students";
        }

        model.addAttribute("student", result.get());
        return "student-edit";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/delete/{regno}")
    public String deleteStudent(
            @PathVariable("regno") int regno) {

        studentService.deleteStudent(regno);
        return "redirect:/students";
    }
}
