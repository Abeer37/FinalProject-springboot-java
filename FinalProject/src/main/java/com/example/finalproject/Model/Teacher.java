package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @NotNull(message = "ID should be not empty")
    private Integer id;
    @NotEmpty(message = "name should be not empty")
    @Column(columnDefinition = "varchar(20)")
    private String name;
    @NotEmpty(message = "salary should be not empty")
    private double salary;

}
