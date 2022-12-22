package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Model.Student;
import com.example.finalproject.Service.CourseService;
import com.example.finalproject.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {
        @Autowired
        private final StudentService studentService;

        @GetMapping("/getstudent")
        public ResponseEntity getStudent(){
            List<Student> students=studentService.getStudent();
            return ResponseEntity.status(200).body(students);
        }
        @PostMapping("/addstudent")
        public ResponseEntity addStudent(@RequestBody @Valid Student student){
            studentService.addStudent(student);
            return ResponseEntity.status(200).body(new ApiResponse("student add!!"));
        }

        @PutMapping("/updatestudent/{id}")
        public ResponseEntity updateStudent(@PathVariable Integer id,@RequestBody@Valid Student student){
            studentService.updateStudent(id,student);
            return ResponseEntity.status(200).body(new ApiResponse("student update!!"));
        }
        @DeleteMapping("/deletestudent/{id}")
        public String deleteStudent(@PathVariable Integer id){
            studentService.deleteStudent(id);
            return "student delete";
        }
        @DeleteMapping("/byage/{age}")
        public String deleteStudentByAge(@PathVariable String age){
           studentService.deleteStudentByAge(age);
            return "student delete";
        }

}

