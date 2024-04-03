package ru.courses.microservicmaximov.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.courses.microservicmaximov.model.Course;
import ru.courses.microservicmaximov.repository.InMemCoursesDAO;
import ru.courses.microservicmaximov.service.CoursesService;

import java.util.List;
@Service
@AllArgsConstructor
public class InMemCoursesServiceImpl implements CoursesService {
    private final InMemCoursesDAO repository;
    @Override
    public List<Course> findAllCourses() {
        return repository.findAllCourses();
    }

    @Override
    public Course saveCourse(Course course) {
        return repository.saveCourse(course);
    }

    @Override
    public Course findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.updateCourse(course);
    }

    @Override
    public void deleteCourse(String title) {
        repository.deleteCourse(title);
    }
}
