package com.company.listener;

import com.company.controller.Controller;
import com.company.model.Student;
import com.company.view.StudentTable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchListener implements Listener {

    private Controller controller;
    private Shell parent;

    public SearchListener(Shell parent, Controller controller) {
        this.parent = parent;
        this.controller = controller;
    }

    @Override
    public void handleEvent(Event e) {
        Shell child = new Shell(parent, SWT.SHELL_TRIM | SWT.RESIZE);
        child.setText("Search...");

        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 5;
        child.setLayout(rowLayout);

        Label nameLabel = new Label(child, SWT.NONE);
        nameLabel.setText("Имя студента");

        Text nameText = new Text(child, SWT.NONE);
        nameText.setLayoutData(new RowData(200, 20));

        Button nameSearchCheck = new Button(child, SWT.CHECK);
        nameSearchCheck.setText("Поиск по имени");

        Label GroupNumberLabel = new Label(child, SWT.NONE);
        GroupNumberLabel.setText("Номер группы");
        Combo combo = new Combo(child, SWT.DROP_DOWN);

        HashSet<String> studentgroup = new HashSet<>();
        for (Student student : controller.getAllStudents()){
            studentgroup.add(student.getGroup());
        }
        String[] stgroup = {};
        stgroup = studentgroup.toArray(new String[studentgroup.size()]);
        combo.setItems(stgroup);

        Text GroupNumberText = new Text(child, SWT.NONE);
        GroupNumberText.setLayoutData(new RowData(200, 20));

        Button GroupNumberSearchButton = new Button(child, SWT.CHECK);
        GroupNumberSearchButton.setText("Поиск по номеру группы");

        combo.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int idx = combo.getSelectionIndex();
                String group = combo.getItem(idx);
                GroupNumberText.setText(group);
            }
        });




        Label totalWork = new Label(child, SWT.NONE);
        totalWork.setText("Верхняя граница(общее число работы)\n");

        Text totalWorkText = new Text(child, SWT.NONE);
        totalWorkText.setLayoutData(new RowData(200, 20));

        Label totalMinWork = new Label(child, SWT.NONE);
        totalMinWork.setText("Нижняя граница(общее число работы)\n");

        Text totalMinWorkText = new Text(child, SWT.NONE);
        totalMinWorkText.setLayoutData(new RowData(200, 20));

        Button totalMinWorkButton = new Button(child, SWT.CHECK);
        totalMinWorkButton.setText("Поиск по верхней и нижней границе\n");


        Button searchButton = new Button(child, SWT.PUSH);
        searchButton.setText("Поиск");

        StudentTable table = new StudentTable(child, SWT.NONE, controller);

        Listener proceedListener = new Listener() {

            @Override
            public void handleEvent(Event e) {
                List<Student> students = new ArrayList<>();

                if (nameSearchCheck.getSelection()) {
                    String name = nameText.getText();
                    students.addAll(controller.findByName(name, controller.getAllStudents()));
                }

                if (GroupNumberSearchButton.getSelection()) {
                    String group = GroupNumberText.getText();
                    students.addAll(controller.findByGroup(group, controller.getAllStudents()));
                }
                if(totalMinWorkButton.getSelection()){
                    String boundUp = totalWorkText.getText();
                    String boundLow = totalMinWorkText.getText();
                    students.addAll(controller.findAll(boundLow,boundUp, controller.getAllStudents()));

                }

                table.updateTable(students);
            }
        };

        searchButton.addListener(SWT.MouseDown, proceedListener);

        //child.pack();
        child.open();
    }
}