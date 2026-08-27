package com.example.github_practice.service;

import com.example.github_practice.entity.Teacher;
import com.example.github_practice.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public Teacher save(Teacher teacher) {
        return repository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    public Teacher getTeacher(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {

        Teacher existing = repository.findById(id).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(teacher.getName());
        existing.setSubject(teacher.getSubject());
        existing.setEmail(teacher.getEmail());
        existing.setExperience(teacher.getExperience());

        return repository.save(existing);
    }

    public void deleteTeacher(Long id) {
        repository.deleteById(id);
    }
}