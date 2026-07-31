package com.example.github_practice.controller;

import com.example.github_practice.entity.Teacher;
import com.example.github_practice.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return service.save(teacher);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return service.getTeacher(id);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id,
                                 @RequestBody Teacher teacher) {
        return service.updateTeacher(id, teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        service.deleteTeacher(id);
    }
}