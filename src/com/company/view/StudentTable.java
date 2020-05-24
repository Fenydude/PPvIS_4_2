package com.company.view;

import com.company.controller.Controller;
import com.company.model.Student;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;


import java.util.ArrayList;
import java.util.List;

public class StudentTable extends Composite {
    private Table table;
    private Controller controller;
    private int numOfStudentsOnPage = 10;
    private int pageNum = 0;
    private Text numOfStudentsText;
    private Label pagesIndicatorLabel;

    private List<Student> searchStudentList;

    public StudentTable(Composite parent, int style, Controller controller) {
        super(parent, style);

        RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 5;
        this.setLayout(rowLayout);

        table = new Table(this, style);
        table.setHeaderVisible(true);
        String[] titles = {"Name", "Group",
                "firstSemestr",
                "SecondSemestr",
                "threethSemestr",
                "fourthSemestr",
                "fivethSemestr",
                "sixthSemestr",
                "seventhSemestr",
                "eighthSemestr",
                "ninthSemestr",
                "tenthSemestr",
                "result",
        };
        for (int i = 0; i < titles.length; i++) {
            TableColumn column = new TableColumn(table, SWT.CENTER);
            column.setText(titles[i]);
            table.getColumn(i).pack();
        }
        this.controller = controller;



        Button previousPageButton = new Button(this, SWT.PUSH);
        previousPageButton.setText("<");
        previousPageButton.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event e) {
                if (pageNum - 1 >= 0) {
                    pageNum--;
                    if (searchStudentList.isEmpty()) {
                        updateTable();
                    } else updateTable(searchStudentList);
                }
            }
        });

        Button nextPageButton = new Button(this, SWT.PUSH);
        nextPageButton.setText(">");
        nextPageButton.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event e) {
                if (searchStudentList.isEmpty()) {
                    if (pageNum + 1 < Math.ceil((double) controller.getAllStudents().size() / numOfStudentsOnPage)) {
                        pageNum++;
                        updateTable();
                    }
                } else {
                    if (pageNum + 1 < Math.ceil((double) searchStudentList.size() / numOfStudentsOnPage)) {
                        pageNum++;
                        updateTable(searchStudentList);
                    }
                }
            }
        });



        searchStudentList = new ArrayList<Student>();
        pagesIndicatorLabel = new Label(this, SWT.NONE);
        pagesIndicatorLabel.setText("1/1");

        this.pack();
        table.pack();
        super.pack();
    }

    private void fillTheTable(List<Student> students) {
        table.removeAll();
        for (Student student : students) {
            try {
                if (student.getName() == null || student.getGroup() == null)
                    throw new Exception("Null student !!!!");
            } catch (Exception ex) {
                System.exit(1);
            }

            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(0, student.getName());
            item.setText(1, student.getGroup());
            item.setText(2, Integer.toString(student.getFirstSemestr()));
            item.setText(3, Integer.toString(student.getSecondSemestr()));
            item.setText(4, Integer.toString(student.getThirdSemestr()));
            item.setText(5, Integer.toString(student.getFourthSemestr()));
            item.setText(6, Integer.toString(student.getFiveSemestr()));
            item.setText(7, Integer.toString(student.getSixthSemestr()));
            item.setText(8, Integer.toString(student.getSeventhSemestr()));
            item.setText(9, Integer.toString(student.getEighthSemestr()));
            item.setText(10, Integer.toString(student.getNinthSemestr()));
            item.setText(11, Integer.toString(student.getTenthSemestr()));
            item.setText(12, Integer.toString(student.getTotal()));
        }
    }

    public void updateTable() {
        List<Student> students = getStudentPage(pageNum, numOfStudentsOnPage, controller.getAllStudents());
        fillTheTable(students);
        pagesIndicatorLabel.setText((pageNum + 1) + "/" + (int) Math.ceil((double) controller.getAllStudents().size() / numOfStudentsOnPage));
        table.pack();
        this.pack();
        //super.pack();
    }


    public void updateTable(List<Student> studentsList) {
        searchStudentList = studentsList;
        List<Student> students = getStudentPage(pageNum, numOfStudentsOnPage, studentsList);
        fillTheTable(students);
        pagesIndicatorLabel.setText((pageNum + 1) + "/" + (int) Math.ceil((double) searchStudentList.size() / numOfStudentsOnPage));
        table.pack();
        this.pack();
    }

    private List<Student> getStudentPage(int index, int numOfStudentsOnPage, List<Student> students) {
        ArrayList<Student> studentOnPAge = new ArrayList<>();
        for (int i = pageNum * 10; i < (pageNum * 10) + 9; ++i) {
            studentOnPAge.add(students.get(i));
        }
        return studentOnPAge;
    }
}