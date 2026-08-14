package com.intute.first_project.service;

import com.intute.first_project.dto.CourseDto;
import com.intute.first_project.dto.StudentDto;
import com.intute.first_project.entity.CourseEntity;
import com.intute.first_project.entity.StudentEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class EntityMapper {

    private EntityMapper() {
    }

    public static StudentEntity toStudentEntity(StudentDto dto, Set<CourseEntity> courses) {
        StudentEntity student = new StudentEntity();
        student.setStudentId(dto.getStudentId());
        student.setStudentName(dto.getStudentName());
        student.setAddress(dto.getAddress());
        student.setCourses(courses == null ? new HashSet<>() : courses);
        return student;
    }

    public static StudentDto toStudentDto(StudentEntity entity) {
        List<String> courseIds = entity.getCourses()
                .stream()
                .map(CourseEntity::getCourseId)
                .toList();

        return new StudentDto(
                entity.getStudentId(),
                entity.getStudentName(),
                entity.getAddress(),
                courseIds
        );
    }

    public static CourseEntity toCourseEntity(CourseDto dto) {
        CourseEntity course = new CourseEntity();
        course.setCourseId(dto.getCourseId());
        course.setCourseName(dto.getCourseName());
        return course;
    }

    public static CourseDto toCourseDto(CourseEntity entity) {
        return new CourseDto(entity.getCourseId(), entity.getCourseName());
    }
}


