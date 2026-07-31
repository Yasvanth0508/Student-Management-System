package com.example.githubpractice.service;

import com.example.githubpractice.entity.Course;
import com.example.githubpractice.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public Course save(Course course) {
        return repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course getCourse(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Course updateCourse(Long id, Course course) {

        Course existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setCourseName(course.getCourseName());
        existing.setFaculty(course.getFaculty());
        existing.setCredits(course.getCredits());

        return repository.save(existing);
    }

    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}