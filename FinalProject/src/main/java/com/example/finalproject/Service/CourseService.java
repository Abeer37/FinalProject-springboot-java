package com.example.finalproject.Service;

import com.example.finalproject.Exception.ApiException;
import com.example.finalproject.Model.Course;
import com.example.finalproject.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private final CourseRepository courseRepository;

    public List<Course> getCourse(){
        return courseRepository.findAll();
    }
    public void addCourse(Course course){
        courseRepository.save(course);
    }
    public Boolean updateCourse(Integer id,Course course){
        Course oldcourse=courseRepository.findCourseById(id);
        if(oldcourse==null){
            return false;
        }
        oldcourse.setCoursename(course.getCoursename());
        courseRepository.save(oldcourse);
        return true;
    }
    public Boolean deleteCourse(Integer id){
        Course course=courseRepository.findCourseById(id);
        if(course==null){
            return false;
        }
        courseRepository.delete(course);
        return true;
    }
}

