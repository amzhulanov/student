package com.example.student.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue
    @Column( columnDefinition = "id", updatable = false )
    protected Long id;

    private String name;

    private Integer mark;

    public Student(String name, Integer mark) {
        this.name=name;
        this.mark=mark;
    }
}
