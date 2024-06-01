package ru.courses.microservicmaximov.repository;

import io.micrometer.core.annotation.Timed;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.courses.microservicmaximov.model.Course;

public interface CoursesRepository extends JpaRepository<Course, Long> {

    void deleteByTitle(String title);
    Course findCourseByTitle(String title);
}
