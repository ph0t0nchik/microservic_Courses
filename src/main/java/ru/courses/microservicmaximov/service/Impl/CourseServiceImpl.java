package ru.courses.microservicmaximov.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.courses.microservicmaximov.model.Course;
import ru.courses.microservicmaximov.repository.CoursesRepository;
import ru.courses.microservicmaximov.service.CoursesService;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class CourseServiceImpl implements CoursesService {
    private final CoursesRepository repository;
    @Override
    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course findByTitle(String title) {
        return repository.findCourseByTitle(title);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    @Override
    @Transactional
    public void deleteCourse(String title) {
        repository.deleteByTitle(title);
    }
}
