package com.company.loader;

import com.company.model.Student;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

public class LoaderHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bGroup = false;
    private boolean bFirst = false;
    private boolean bSecond = false;
    private boolean bTrird = false;
    private boolean bFourt = false;
    private boolean bFive = false;
    private boolean bSix = false;
    private boolean bSeven = false;
    private boolean bEigth = false;
    private boolean bNine = false;
    private boolean bTen = false;
    private boolean bRes = false;

    private List<Student> students = null;
    private Student student = null;
    private StringBuilder data;

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if(qName.equalsIgnoreCase("student")) {
            student = new Student();
            if(students == null) {
                students = new ArrayList<Student>();
            }
        }
        else if (qName.equalsIgnoreCase("Name")) {
            bName = true;
        }
        else if (qName.equalsIgnoreCase("Group")) {
            bGroup = true;
        }
        else if (qName.equalsIgnoreCase("firstSemestr")) {
            bFirst = true;
        }
        else if (qName.equalsIgnoreCase("SecondSemestr")) {
            bSecond = true;
        }
        else if (qName.equalsIgnoreCase("threethSemestr")) {
            bTrird = true;
        }
        else if (qName.equalsIgnoreCase("fourthSemestr")) {
            bFourt = true;
        }
        else if (qName.equalsIgnoreCase("fivethSemestr")) {
            bFive = true;
        }
        else if (qName.equalsIgnoreCase("sixthSemestr")) {
            bSix = true;
        }
        else if (qName.equalsIgnoreCase("seventhSemestr")) {
            bSeven = true;
        }
        else if (qName.equalsIgnoreCase("eighthSemestr")) {
            bEigth = true;
        }
        else if (qName.equalsIgnoreCase("ninthSemestr")) {
            bNine = true;
        }
        else if (qName.equalsIgnoreCase("tenthSemestr")) {
            bTen = true;
        }

        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(bName) {
            student.setName(data.toString());
            bName = false;
        }
        else if (bGroup) {
            student.setGroup(data.toString());
            bGroup = false;
        }
        else if (bFirst) {
            student.setFirstSemestr(Integer.parseInt(data.toString()));
            bFirst = false;
        }
        else if (bSecond) {
            student.setSecondSemestr(Integer.parseInt(data.toString()));
            bSecond = false;
        }
        else if (bTrird) {
            student.setThirdSemestr(Integer.parseInt(data.toString()));
            bTrird = false;
        }
        else if (bFourt) {
            student.setFourthSemestr(Integer.parseInt(data.toString()));
            bFourt = false;
        }
        else if (bFive) {
            student.setFiveSemestr(Integer.parseInt(data.toString()));
            bFive = false;
        }
        else if (bSix) {
            student.setSixthSemestr(Integer.parseInt(data.toString()));
            bSix = false;
        }
        else if (bSeven) {
            student.setSeventhSemestr(Integer.parseInt(data.toString()));
            bSeven = false;
        }
        else if (bEigth) {
            student.setEighthSemestr(Integer.parseInt(data.toString()));
            bEigth = false;
        }
        else if (bNine) {
            student.setNinthSemestr(Integer.parseInt(data.toString()));
            bNine = false;
        }
        else if (bTen) {
            student.setTenthSemestr(Integer.parseInt(data.toString()));
            bTen = false;
        }

        if (qName.equalsIgnoreCase("Student")) {
            students.add(student);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}