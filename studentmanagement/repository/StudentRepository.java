package com.university.studentmanagement.repository;

import com.university.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourseYear(Integer courseYear);
    
    @Query("SELECT s FROM Student s WHERE s.averageGrade >= :minGrade AND s.averageGrade <= :maxGrade")
    List<Student> findByAverageGradeBetween(@Param("minGrade") Double minGrade, @Param("maxGrade") Double maxGrade);
    
    List<Student> findByCourseYearAndAverageGradeBetween(Integer courseYear, Double minGrade, Double maxGrade);
} 