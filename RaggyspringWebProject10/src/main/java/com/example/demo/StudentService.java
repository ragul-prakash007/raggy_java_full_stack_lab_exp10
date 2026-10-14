
package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Add or update student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // View all students
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Search student
    @Transactional(readOnly = true)
    public Optional<Student> getStudentByRegno(int regno) {
        return studentRepository.findById(regno);
    }

    // Delete student
    public void deleteStudent(int regno) {
        studentRepository.deleteById(regno);
    }
}
