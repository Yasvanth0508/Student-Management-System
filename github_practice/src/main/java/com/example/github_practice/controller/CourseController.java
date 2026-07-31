package com.example.githubpractice.controller;

import com.example.githubpractice.entity.Course;
import com.example.githubpractice.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return service.save(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return service.getCourse(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id,
                               @RequestBody Course course) {
        return service.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }
}