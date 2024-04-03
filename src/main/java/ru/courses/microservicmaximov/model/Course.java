package ru.courses.microservicmaximov.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String short_decription;
    private String decription;
    private Integer price;
}
