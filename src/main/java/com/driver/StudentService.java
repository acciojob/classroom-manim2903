package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudentToDb(student);

    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacherToDb(teacher);

    }
    public void addStudentTeacherPair(String studentName, String teacherName){
        studentRepository.addStudentTeacherPairTODb(teacherName,studentName);
    }
    public Student findStudent(String student){
        return studentRepository.findStudent(student);
    }
    public Teacher findTeacher(String teacher){
        return studentRepository.findTeacher(teacher);
    }
    public List<String> findStudentsToTeacher(String teacher){
        return studentRepository.findStudentsTOTeacher(teacher);
    }
    public List<String> findAllStudents(){
        return studentRepository.findAllStudents();
    }
    public void deleteTeacher(String teacher){
        studentRepository.deleteTeacher(teacher);
    }
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
