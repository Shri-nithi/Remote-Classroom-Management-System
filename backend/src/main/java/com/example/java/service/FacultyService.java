package com.example.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.entity.Faculty;
import com.example.java.repository.FacultyRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    public void deleteFaculty(Long id) {
    facultyRepository.deleteById(id);
}
public Faculty updateFaculty(Long id, Faculty faculty) {

    Faculty existingFaculty = facultyRepository.findById(id).orElse(null);

    if(existingFaculty != null){

        existingFaculty.setFacultyId(faculty.getFacultyId());
        existingFaculty.setName(faculty.getName());
        existingFaculty.setEmail(faculty.getEmail());
        existingFaculty.setDepartment(faculty.getDepartment());
        existingFaculty.setPhone(faculty.getPhone());

        return facultyRepository.save(existingFaculty);
    }

    return null;
}
}