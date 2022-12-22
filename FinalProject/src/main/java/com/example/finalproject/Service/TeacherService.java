package com.example.finalproject.Service;

import com.example.finalproject.Exception.ApiException;
import com.example.finalproject.Model.Teacher;
import com.example.finalproject.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Boolean updateTeacher(Integer id, Teacher teacher) {
        Teacher oldteacher = teacherRepository.findTeacherById(id);
        if (oldteacher == null) {
            return false;
        }
        oldteacher.setName(teacher.getName());
        oldteacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldteacher);
        return true;
    }
    public Boolean updateTeacherBySalary(double salary,Teacher teacher){
        Teacher oldteacher=teacherRepository.findTeacherBySalary(salary);
        if(teacher==null){
            return false;
        }
        oldteacher.setName(teacher.getName());
        oldteacher.setId(teacher.getId());
        teacherRepository.save(oldteacher);
        return true;
    }

    public Boolean deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            return false;
        }
        teacherRepository.delete(teacher);
        return true;
    }
}