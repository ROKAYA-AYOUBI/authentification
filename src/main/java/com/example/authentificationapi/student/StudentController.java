package com.example.authentificationapi.student;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/auth")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/registerStudent")
    public Student registerStudent(@RequestBody Student student) {

        return studentService.registerStudent(student);
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(){

        return studentService.getStudents();
    }

    @DeleteMapping("/deleteStudent")
    public void deleteStudent(@RequestParam Integer id) {

        studentService.deleteStudent(id);
    }

    @PutMapping("/updateStudents")
    public Student updateStudent(@RequestBody Student student) {
        return  studentService.updateStudent(student);
    }
}
