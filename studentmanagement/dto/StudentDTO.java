package com.university.studentmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    
    @NotNull(message = "Course year is required")
    @Min(value = 1, message = "Course year must be at least 1")
    @Max(value = 6, message = "Course year must not exceed 6")
    private Integer courseYear;
    
    @NotNull(message = "Average grade is required")
    @DecimalMin(value = "0.0", message = "Average grade must be at least 0.0")
    @DecimalMax(value = "5.0", message = "Average grade must not exceed 5.0")
    private Double averageGrade;
} 