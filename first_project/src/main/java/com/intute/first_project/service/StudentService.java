package com.intute.first_project.service;

import com.intute.first_project.dto.StudentDto;
import com.intute.first_project.entity.CourseEntity;
import com.intute.first_project.entity.StudentEntity;
import com.intute.first_project.exception.ResourceNotFoundException;
import com.intute.first_project.repo.CourseRepository;
import com.intute.first_project.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public StudentDto createStudent(StudentDto studentDto) {
        Set<CourseEntity> courses = resolveCourses(studentDto.getCourseIds());

        StudentEntity studentEntity = EntityMapper.toStudentEntity(studentDto, courses);
        StudentEntity saved = studentRepository.save(studentEntity);
        return EntityMapper.toStudentDto(saved);
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(EntityMapper::toStudentDto)
                .toList();
    }

    public StudentDto getStudentById(String studentId) {
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + studentId));
        return EntityMapper.toStudentDto(student);
    }

    public StudentDto updateStudent(String studentId, StudentDto updatedStudent) {
        StudentEntity existing = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found: " + studentId));

        existing.setStudentName(updatedStudent.getStudentName());
        existing.setAddress(updatedStudent.getAddress());
        existing.setCourses(resolveCourses(updatedStudent.getCourseIds()));

        StudentEntity saved = studentRepository.save(existing);
        return EntityMapper.toStudentDto(saved);
    }

    public void deleteStudent(String studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new ResourceNotFoundException("Student not found: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    private Set<CourseEntity> resolveCourses(List<String> courseIds) {
        if (courseIds == null || courseIds.isEmpty()) {
            return new HashSet<>();
        }
        //{1,2,3,4,5}
        //{course1,course,course3}
        List<CourseEntity> courses = courseRepository.findAllById(courseIds);
        if (courses.size() != courseIds.size()) {
            throw new ResourceNotFoundException("One or more courseIds do not exist");
        }
        return new HashSet<>(courses);
    }
}
