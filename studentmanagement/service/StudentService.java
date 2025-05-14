package com.university.studentmanagement.service;

import com.university.studentmanagement.dto.StudentDTO;
import com.university.studentmanagement.entity.Student;
import com.university.studentmanagement.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
        return convertToDTO(student);
    }

    @Transactional
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
        
        updateStudentFromDTO(student, studentDTO);
        Student updatedStudent = studentRepository.save(student);
        return convertToDTO(updatedStudent);
    }

    @Transactional
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    public List<StudentDTO> findByCourseYear(Integer courseYear) {
        return studentRepository.findByCourseYear(courseYear).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> findByAverageGradeBetween(Double minGrade, Double maxGrade) {
        return studentRepository.findByAverageGradeBetween(minGrade, maxGrade).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentDTO> findByCourseYearAndAverageGrade(Integer courseYear, Double minGrade, Double maxGrade) {
        return studentRepository.findByCourseYearAndAverageGradeBetween(courseYear, minGrade, maxGrade).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Student convertToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setCourseYear(dto.getCourseYear());
        student.setAverageGrade(dto.getAverageGrade());
        return student;
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setCourseYear(student.getCourseYear());
        dto.setAverageGrade(student.getAverageGrade());
        return dto;
    }

    private void updateStudentFromDTO(Student student, StudentDTO dto) {
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setCourseYear(dto.getCourseYear());
        student.setAverageGrade(dto.getAverageGrade());
    }
} 