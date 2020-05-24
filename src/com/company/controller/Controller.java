package com.company.controller;

import com.company.loader.Loader;
import com.company.model.Student;
import com.company.saver.Saver;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Student> students;
    private Loader loader;
    private Saver saver;

    public Controller(List<Student> students) {
        this.students = students;
        loader = new Loader();
        saver = new Saver();
    }

    public void load(String filePath) {
        this.students = loader.load(filePath);
    }

    public void save(String filePath) {
        saver.save(this.students, filePath);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void addStudent(String name, String group, int first, int second, int third,
                           int fouth, int five, int six, int seven, int eigth, int nine, int ten , int result) {
        Student student = new Student();
        student.setName(name);
        student.setGroup(group);
        student.setFirstSemestr(first);
        student.setSecondSemestr(second);
        student.setThirdSemestr(third);
        student.setFourthSemestr(fouth);
        student.setFiveSemestr(five);
        student.setSixthSemestr(six);
        student.setSeventhSemestr(seven);
        student.setEighthSemestr(eigth);
        student.setNinthSemestr(nine);
        student.setTenthSemestr(ten);



        students.add(student);
    }

    public void deleteStudents(List<Student> students) {
        for (Student student : students) {
            this.students.remove(student);
        }
    }



    public List<Student> findByName(String name, List<Student> studentsList) {
        List<Student> students = new ArrayList<Student>();
        for (Student student : studentsList) {
            if (student.getName().contains(name)) {
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> findByGroupBorder(String group, String low,String up, List<Student> studentList ){
        List<Student> students = new ArrayList<Student>();
        Integer i2 = Integer.valueOf(low);
        Integer i1 = Integer.valueOf(up);
        for (Student student : studentList) {
            if (student.getGroup().contains(group) && student.getTotal() >= i2 && student.getTotal() <=i1) {
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> findByGroup(String group, List<Student> studentList) {
        List<Student> students = new ArrayList<Student>();
        for (Student student : studentList) {
            if (student.getGroup().contains(group)) {
                students.add(student);
            }
        }
        return students;
    }
   /* public List<Student> findByUpperBound(String upperBound, List<Student> studentList) {
        List<Student> students = new ArrayList<Student>();
        Integer i2 = Integer.valueOf(upperBound);
        for (Student student : studentList) {
            if (student.getTotal() <= i2) {
                students.add(student);
            }
        }
        return students;
    }
    public List<Student> findByLowBound(String low, List<Student> studentList) {
        List<Student> students = new ArrayList<Student>();
        Integer i2 = Integer.valueOf(low);
        for (Student student : studentList) {
            if (student.getTotal() >= i2) {
                students.add(student);
            }
        }
        return students;
    }*/
    public List<Student> findAll(String low,String up, List<Student> studentList) {
        List<Student> students = new ArrayList<Student>();
        Integer i2 = Integer.valueOf(low);
        Integer i1 = Integer.valueOf(up);
        for (Student student : studentList) {
            if (student.getTotal() >= i2 && student.getTotal() <=i1) {
                students.add(student);
            }
        }
        return students;
    }






}