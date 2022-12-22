package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Model.Teacher;
import com.example.finalproject.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    @GetMapping("/getteacher")
    public ResponseEntity getTeacher(){
        List<Teacher> teachers=teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }
    @PostMapping("/addteacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher add!!"));
    }
    @PutMapping("/updateteacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody@Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher update!!"));
    }
    @PutMapping("/bysalary/{salary}")
    public ResponseEntity updateBlogBySalary(@PathVariable double salary,@RequestBody@Valid Teacher teacher){
        teacherService.updateTeacherBySalary(salary,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher update!!"));
    }
    @DeleteMapping("/deletteacher/{id}")
    public String deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return "teacher delete";
    }
}
