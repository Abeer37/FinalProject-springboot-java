package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Model.Course;
import com.example.finalproject.Model.Student;
import com.example.finalproject.Service.CourseService;
import com.example.finalproject.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/getcourse")
    public ResponseEntity getCourse(){
        List<Course> courses=courseService.getCourse();
        return ResponseEntity.status(200).body(courses);
    }
    @PostMapping("/addcourse")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("course add!!"));
    }
    @PutMapping("/updatecourse/{id}")
    public ResponseEntity updateCourse(@PathVariable(name = "id") Integer id,@RequestBody@Valid Course course){
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("course update!!"));
    }
    @DeleteMapping("/deletecourse/{id}")
    public String deleteCourse(@PathVariable(name="id") Integer id){
        courseService.deleteCourse(id);
        return "course delete";
    }
}
