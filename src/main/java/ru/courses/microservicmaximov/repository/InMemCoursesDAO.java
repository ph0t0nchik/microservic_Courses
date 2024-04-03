package ru.courses.microservicmaximov.repository;

import org.springframework.stereotype.Repository;
import ru.courses.microservicmaximov.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Repository
public class InMemCoursesDAO {
    private final List<Course> COURSES = new ArrayList<>();


    public List<Course> findAllCourses() {
        return COURSES;
    }


    public Course saveCourse(Course course) {
        COURSES.add(course);
        return course;
    }


    public Course findByTitle(String title) {
        return COURSES.stream()
                .filter(element->element.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }


    public Course updateCourse(Course course) {
        var courseIndex = IntStream.range(0,COURSES.size())
                .filter(index->COURSES.get(index).getTitle().equals(course.getTitle()))
                .findFirst()
                .orElse(-1);
        if (courseIndex > -1) {
            COURSES.set(courseIndex, course);
            return course;
        }
        return null;
    }


    public void deleteCourse(String title) {
        var course = findByTitle(title);
        if (course != null){
            COURSES.remove(course);
        }
    }
}
