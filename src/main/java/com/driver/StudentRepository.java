package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

    private HashMap<String,Student> studentDb;
    private HashMap<String,Teacher> teacherDb;
    private HashMap<String,List<String>> studentTeacherPairDb;

    public StudentRepository(){
        this.studentDb=new HashMap<>();
        this.teacherDb=new HashMap<>();
        this.studentTeacherPairDb=new HashMap<>();
    }

    public void addStudentToDb(Student student){
        String key=student.getName();
        //Add it to student
        studentDb.put(key,student);

    }
    public void addTeacherToDb(Teacher teacher){
        String key=teacher.getName();
        //Add it to student
        teacherDb.put(key,teacher);

    }
    public void addStudentTeacherPairTODb(String teacherName,String studentName){
        if(studentDb.containsKey(studentName) && teacherDb.containsKey(teacherName)){
            List<String> studentsToTeacher=new ArrayList<>();
            if(studentTeacherPairDb.containsKey(teacherName)){
                studentsToTeacher=studentTeacherPairDb.get(teacherName);
            }
            studentsToTeacher.add(studentName);
            studentTeacherPairDb.put(teacherName,studentsToTeacher);
        }
    }
    public Student findStudent(String name){
        return studentDb.get(name);
    }
    public Teacher findTeacher(String name){
        return  teacherDb.get(name);
    }
    public List<String> findStudentsTOTeacher(String teacher){
        List<String> studentsList=new ArrayList<>();
        if(studentTeacherPairDb.containsKey(teacher)){
            studentsList=studentTeacherPairDb.get(teacher);
        }
        return studentsList;
    }
    public List<String> findAllStudents(){
        return new ArrayList<>(studentDb.keySet());
    }
    public void deleteTeacher(String name){
        List<String> students=new ArrayList<>();
        if(studentDb.containsKey(name)){
            //1.Find the student names by teacher name from the pair
            students=studentTeacherPairDb.get(name);

            //2.Deleting all students from studentDb by using student name
            for(String student : students){
                if(studentDb.containsKey(student)){
                    studentDb.remove(student);
                }
            }
            //3.Delete the pair
            studentTeacherPairDb.remove(name);
        }
        //4.Delete the teacher from teacherDb
        if(teacherDb.containsKey(name)){
            teacherDb.remove(name);
        }
    }
    public void deleteAllTeachers(){
        HashSet<String> studentsSet=new HashSet<>();

        //Delete the teacherDb
        teacherDb=new HashMap<>();

        //Finding all the students by all the teachers combined
        for(String teacher : studentTeacherPairDb.keySet()){
            //Iterating in the list of students by teacher
            for(String student : studentTeacherPairDb.get(teacher)){
                studentsSet.add(student);
            }
        }
        //Deleting the student from the studentDb
        for(String student : studentsSet){
            if(studentDb.containsKey(student)){
                studentDb.remove(student);
            }
        }
        //Clearing the student-teacher pair
        studentTeacherPairDb=new HashMap<>();
    }
}
