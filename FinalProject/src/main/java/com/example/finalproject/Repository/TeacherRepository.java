package com.example.finalproject.Repository;

import com.example.finalproject.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
    Teacher findTeacherBySalary(double salary);
}


