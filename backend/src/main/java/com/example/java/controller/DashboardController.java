package com.example.java.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.repository.AssignmentRepository;
import com.example.java.repository.CourseRepository;
import com.example.java.repository.FacultyRepository;
import com.example.java.repository.StudentRepository;


@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {


    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private FacultyRepository facultyRepository;


    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private AssignmentRepository assignmentRepository;




    @GetMapping("/count")
    public Map<String, Long> getDashboardCount(){


        Map<String, Long> data = new HashMap<>();


        data.put(
            "students",
            studentRepository.count()
        );


        data.put(
            "faculty",
            facultyRepository.count()
        );


        data.put(
            "courses",
            courseRepository.count()
        );


        data.put(
            "assignments",
            assignmentRepository.count()
        );


        return data;

    }

}