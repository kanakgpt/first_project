package com.intute.first_project.service;

import com.intute.first_project.dto.CourseDto;
import com.intute.first_project.entity.CourseEntity;
import com.intute.first_project.exception.ResourceNotFoundException;
import com.intute.first_project.repo.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDto createCourse(CourseDto dto) {
        CourseEntity saved = courseRepository.save(EntityMapper.toCourseEntity(dto));
        return EntityMapper.toCourseDto(saved);
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(EntityMapper::toCourseDto)
                .toList();
    }

    public CourseDto getCourseById(String courseId) {
        CourseEntity course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found: " + courseId));
        return EntityMapper.toCourseDto(course);
    }
}

