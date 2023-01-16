package io.javabot.studentapi.controller;

import io.javabot.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.javabot.studentapi.entity.Student;

import java.util.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public Optional<Student> getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @RequestMapping(value = "/students/student", method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
        public void updateStudent(@PathVariable int id, @RequestBody Student student){
        studentService.updateStudent( id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @DeleteMapping("/students")
    public void deleteStudents(){
        studentService.deleteStudents();
    }

}


