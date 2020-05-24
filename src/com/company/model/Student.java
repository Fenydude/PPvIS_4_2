package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int total;
    private List<Integer> sem_work = new ArrayList<>();


    public int getTotal() {
        return total;
    }

    public int getTenthSemestr() {
        return sem_work.get(9);
    }

    public void setTenthSemestr(int tenthSemestr) {
        this.sem_work.add(tenthSemestr);
        this.total += tenthSemestr;
    }

    public int getNinthSemestr() {
        return sem_work.get(8);
    }

    public void setNinthSemestr(int ninthSemestr) {
        this.sem_work.add(ninthSemestr);
        this.total += ninthSemestr;
    }

    public int getEighthSemestr() {
        return sem_work.get(7);
    }

    public void setEighthSemestr(int eighthSemestr) {
        this.sem_work.add(eighthSemestr);
        this.total += eighthSemestr;
    }

    public int getSeventhSemestr() {
        return sem_work.get(6);
    }

    public void setSeventhSemestr(int seventhSemestr) {
        this.sem_work.add(seventhSemestr);
        this.total += seventhSemestr;
    }

    public int getSixthSemestr() {
        return sem_work.get(5);
    }

    public void setSixthSemestr(int sixthSemestr) {
        this.sem_work.add(sixthSemestr);
        this.total += sixthSemestr;
    }

    public int getFiveSemestr() {
        return sem_work.get(4);
    }

    public void setFiveSemestr(int fiveSemestr) {
        this.sem_work.add(fiveSemestr);
        this.total += fiveSemestr;
    }

    public int getFourthSemestr() {
        return sem_work.get(3);
    }

    public void setFourthSemestr(int fourthSemestr) {
        this.sem_work.add(fourthSemestr);
        this.total += fourthSemestr;
    }

    public int getThirdSemestr() {
        return sem_work.get(2);
    }

    public void setThirdSemestr(int thirdSemestr) {
        this.sem_work.add(thirdSemestr);
        this.total += thirdSemestr;
    }

    public int getSecondSemestr() {
        return sem_work.get(1);
    }

    public void setSecondSemestr(int secondSemestr) {
        this.sem_work.add(secondSemestr);
        this.total += secondSemestr;
    }

    public int getFirstSemestr() {
        return sem_work.get(0);

    }

    public void setFirstSemestr(int firstSemestr) {
        this.sem_work.add(firstSemestr);
        this.total += firstSemestr;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}