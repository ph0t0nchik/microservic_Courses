package ru.courses.microservicmaximov.service;

import org.springframework.stereotype.Service;
import ru.courses.microservicmaximov.model.Course;

import java.util.List;

public interface CoursesService {
    List<Course> findAllCourses();
    Course saveCourse(Course course);
    Course findByTitle(String title);
    Course updateCourse(Course course);
    void deleteCourse(String title);
}
