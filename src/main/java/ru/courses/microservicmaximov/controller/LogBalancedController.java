package ru.courses.microservicmaximov.controller;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogBalancedController {
    private static final Logger logger = LoggerFactory.getLogger(CoursesController.class);

    @Value("${server.port}")
    private String serverPort;
    @Timed("loggerBalanced")
    @GetMapping("/test")
    public String handleRequest() {
        logger.info("Запрос обработан на инстансе с портом: {}", serverPort);
        return "Запрос обработан на порту: " + serverPort;
    }
}
