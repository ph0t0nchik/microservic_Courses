package ru.courses.microservicmaximov.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.courses.microservicmaximov.model.Course;
import ru.courses.microservicmaximov.service.CoursesService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@AllArgsConstructor
public class CoursesController {
    private final CoursesService service;
    @GetMapping
    public List<Course> findAllCourses(){
        //todo
        return service.findAllCourses();
    }
    @PostMapping("save_course")
    public String saveCourse(@RequestBody Course course){
        service.saveCourse(course);
        return "Course successfully saved";
    }

    @GetMapping("/{title}")
    public Course findByTitle(@PathVariable String title){
        return service.findByTitle(title);
    }

    @PutMapping("update_course")
    public Course updateCourse(@RequestBody Course course){
        return service.updateCourse(course);
    }

    @DeleteMapping("delete_course/{title}")
    public void deleteCourse(@PathVariable String title){
        service.deleteCourse(title);
    }
}
