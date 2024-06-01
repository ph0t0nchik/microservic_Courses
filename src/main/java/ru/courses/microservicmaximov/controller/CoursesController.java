package ru.courses.microservicmaximov.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.courses.microservicmaximov.model.Course;
import ru.courses.microservicmaximov.service.CoursesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {
    private static final Logger logger = LoggerFactory.getLogger(CoursesController.class);

    @Value("${server.port}")
    private String serverPort; // Переменная для хранения порта сервера

    private final CoursesService service;

    // Явный конструктор для внедрения зависимости
    public CoursesController(CoursesService service) {
        this.service = service;
    }

    @Timed("findAllCourses")
    @GetMapping
    public List<Course> findAllCourses(){
        logger.info("GET findAllCourses request on port {}", serverPort);
        return service.findAllCourses();
    }
    @Timed("saveCourse")
    @PostMapping("save_course")
    public String saveCourse(@RequestBody Course course){
        logger.info("POST saveCourse request on port {}", serverPort);
        service.saveCourse(course);
        return "Course successfully saved";
    }
    @Timed("findByTitle")
    @GetMapping("/{title}")
    public Course findByTitle(@PathVariable String title){
        logger.info("GET findByTitle request on port {}", serverPort);
        return service.findByTitle(title);
    }

    @Timed("updateCourse")
    @PutMapping("update_course")
    public Course updateCourse(@RequestBody Course course){
        logger.info("PUT updateCourse request on port {}", serverPort);
        return service.updateCourse(course);
    }

    @Timed("deleteCourse")
    @DeleteMapping("delete_course/{title}")
    public void deleteCourse(@PathVariable String title){
        logger.info("DELETE deleteCourse request on port {}", serverPort);
        service.deleteCourse(title);
    }
}
