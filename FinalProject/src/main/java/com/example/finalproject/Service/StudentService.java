package com.example.finalproject.Service;

import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Exception.ApiException;
import com.example.finalproject.Model.Student;
import com.example.finalproject.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public Boolean updateStudent(Integer id,Student student){
        Student oldstudent=studentRepository.findStudentById(id);
        if(oldstudent==null){
            return false;
        }
        oldstudent.setName(student.getName());
        oldstudent.setMajor(student.getMajor());
        studentRepository.save(oldstudent);
        return true;
    }
    public Boolean deleteStudent(Integer id){
        Student student=studentRepository.findStudentById(id);
        if(student==null){
            return false;
        }
        studentRepository.delete(student);
        return true;
    }
    public boolean deleteStudentByAge(String age){
        Student student=studentRepository.findStudentsByAge(age);
        if(student==null){
            return false;
        }
        studentRepository.delete(student);
        return true;
    }
}
