package com.intute.first_project.controller;

import com.intute.first_project.dto.StudentDto;
import com.intute.first_project.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE - POST /api/student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody  StudentDto student) {
        System.out.println("Inside createStudent");
        StudentDto created = studentService.createStudent(student);
        System.out.println("Created Student");
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ ALL - GET /api/student
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // READ BY ID - GET /api/student/{sId}
    @GetMapping("/{sId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String sId) {
        StudentDto student = studentService.getStudentById(sId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // UPDATE - PUT /api/student/{sId}
    @PutMapping("/{sId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String sId,
                                                     @Valid @RequestBody StudentDto updatedStudent) {
        StudentDto student = studentService.updateStudent(sId, updatedStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // DELETE - DELETE /api/student/{sId}
    @DeleteMapping("/{sId}")
    public ResponseEntity<String> deleteStudent(@PathVariable String sId) {
        studentService.deleteStudent(sId);
        return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
    }
}
