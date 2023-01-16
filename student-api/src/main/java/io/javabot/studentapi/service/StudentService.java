package io.javabot.studentapi.service;

import io.javabot.studentapi.entity.Student;
import io.javabot.studentapi.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Optional<Student> getStudent(int id) {
        return studentRepository.findById(id);

    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(int id, Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public void deleteStudents() {
        studentRepository.deleteAll();
    }
}
