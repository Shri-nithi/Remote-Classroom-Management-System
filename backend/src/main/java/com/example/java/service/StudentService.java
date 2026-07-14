package com.example.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.entity.Student;
import com.example.java.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
}
public Student updateStudent(Long id, Student student) {

    Student existingStudent = studentRepository.findById(id).orElse(null);

    if(existingStudent != null){

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setPhone(student.getPhone());

        return studentRepository.save(existingStudent);

    }

    return null;
}
}