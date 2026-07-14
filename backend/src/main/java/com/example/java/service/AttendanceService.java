package com.example.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.entity.Attendance;
import com.example.java.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }
    public void deleteAttendance(Long id) {

    attendanceRepository.deleteById(id);

}
public Attendance updateAttendance(Long id, Attendance attendance) {

    Attendance existingAttendance =
            attendanceRepository.findById(id).orElse(null);

    if (existingAttendance != null) {

        existingAttendance.setStudentId(attendance.getStudentId());
        existingAttendance.setStudentName(attendance.getStudentName());
        existingAttendance.setCourseCode(attendance.getCourseCode());
        existingAttendance.setDate(attendance.getDate());
        existingAttendance.setStatus(attendance.getStatus());

        return attendanceRepository.save(existingAttendance);
    }

    return null;
}
}