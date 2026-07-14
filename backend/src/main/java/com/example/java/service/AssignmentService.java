package com.example.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.entity.Assignment;
import com.example.java.repository.AssignmentRepository;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }
    public void deleteAssignment(Long id) {

    assignmentRepository.deleteById(id);

}
public Assignment updateAssignment(Long id, Assignment assignment) {

    Assignment existingAssignment =
            assignmentRepository.findById(id).orElse(null);

    if (existingAssignment != null) {

        existingAssignment.setTitle(assignment.getTitle());
        existingAssignment.setCourseCode(assignment.getCourseCode());
        existingAssignment.setFacultyName(assignment.getFacultyName());
        existingAssignment.setDueDate(assignment.getDueDate());

        return assignmentRepository.save(existingAssignment);
    }

    return null;
}
}