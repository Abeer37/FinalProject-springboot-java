package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="student")
public class Student {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @NotNull(message = "ID should be not empty")
    private Integer id;
    @NotEmpty(message = "name should be not empty")
    @Column(columnDefinition = "varchar(30)")
    private String name;
    @NotEmpty(message = "name should be not empty")
    private String age;
    @NotEmpty(message = "name should be not empty")
    private String major;

}
