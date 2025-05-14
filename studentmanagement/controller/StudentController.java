package com.university.studentmanagement.controller;

import com.university.studentmanagement.dto.StudentDTO;
import com.university.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        StudentDTO createdStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(
            @RequestParam(required = false) Integer courseYear,
            @RequestParam(required = false) Double minGrade,
            @RequestParam(required = false) Double maxGrade) {
        
        List<StudentDTO> students;
        
        if (courseYear != null && minGrade != null && maxGrade != null) {
            students = studentService.findByCourseYearAndAverageGrade(courseYear, minGrade, maxGrade);
        } else if (courseYear != null) {
            students = studentService.findByCourseYear(courseYear);
        } else if (minGrade != null && maxGrade != null) {
            students = studentService.findByAverageGradeBetween(minGrade, maxGrade);
        } else {
            students = studentService.getAllStudents();
        }
        
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        StudentDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
} 