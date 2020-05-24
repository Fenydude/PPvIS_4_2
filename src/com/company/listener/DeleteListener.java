package com.company.listener;

import com.company.controller.Controller;
import com.company.model.Student;
import com.company.view.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;


import java.util.ArrayList;
import java.util.List;

public class DeleteListener implements Listener {

    private Controller controller;
    private Window window;
    private Shell parent;

    public DeleteListener(Shell parent, Controller controller, Window window) {
        this.parent = parent;
        this.controller = controller;
        this.window = window;
    }

    @Override
    public void handleEvent(Event e) {
        Shell child = new Shell(parent, SWT.SHELL_TRIM | SWT.RESIZE);
        child.setText("Deletion...");

        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 5;
        child.setLayout(rowLayout);

        Label nameLabel = new Label(child, SWT.NONE);
        nameLabel.setText("Введите имя студента:");

        Text nameText = new Text(child, SWT.NONE);
        nameText.setLayoutData(new RowData(200, 20));

        Button nameSearchCheck = new Button(child, SWT.CHECK);
        nameSearchCheck.setText("Удалить по имени");

        Label groupLabel = new Label(child, SWT.NONE);
        groupLabel.setText("Введите группу:");

        Text groupText = new Text(child, SWT.NONE);
        groupText.setLayoutData(new RowData(200, 20));

        Button groupSearchCheck = new Button(child, SWT.CHECK);
        groupSearchCheck.setText("Удалить по группе");

        Label totalWork = new Label(child, SWT.NONE);
        totalWork.setText("Верхняя граница(общее число работы)\n");

        Text totalWorkText = new Text(child, SWT.NONE);
        totalWorkText.setLayoutData(new RowData(200, 20));

        Label totalMinWork = new Label(child, SWT.NONE);
        totalMinWork.setText("Нижняя граница(общее число работы)\n");

        Text totalMinWorkText = new Text(child, SWT.NONE);
        totalMinWorkText.setLayoutData(new RowData(200, 20));

        Button totalMinWorkButton = new Button(child, SWT.CHECK);
        totalMinWorkButton.setText("Удаление по верхней и нижней границу\n");

        Button deleteButton = new Button(child, SWT.NONE);
        deleteButton.setText("Удалить");

        Listener proceedListener = new Listener() {
            @Override
            public void handleEvent(Event e) {

                boolean chek = true;
                List<Student> students = new ArrayList<>();

                if(nameSearchCheck.getSelection() && totalMinWorkButton.getSelection() && chek){
                    chek = false;
                    String group = groupText.getText();
                    String boundUp = totalWorkText.getText();
                    String boundLow = totalMinWorkText.getText();
                    students = controller.findByGroupBorder(group,boundLow,boundUp, controller.getAllStudents());
                }

                if (groupSearchCheck.getSelection()) {
                    chek = false;
                    String group = groupText.getText();
                    students.addAll(controller.findByGroup(group, controller.getAllStudents()));
                }


                if (nameSearchCheck.getSelection() && chek) {
                    chek = false;
                    String name = nameText.getText();
                    students = controller.findByName(name, controller.getAllStudents());
                }

                if(totalMinWorkButton.getSelection() && chek){
                    chek = false;
                    String boundUp = totalWorkText.getText();
                    String boundLow = totalMinWorkText.getText();
                    students.addAll(controller.findAll(boundLow,boundUp, controller.getAllStudents()));

                }
                // put deleted students into a `students`
                Shell dialog = new Shell(child);
                dialog.setText("Action");
                dialog.setLayout(new FillLayout());
                Label resultLabel = new Label(dialog, SWT.NONE);
                if (students.size() != 0) {
                    controller.deleteStudents(students);
                    window.updateTable();
                    resultLabel.setText("Was deleted " + students.size() + " students.");
                } else resultLabel.setText("No such students.");
                dialog.pack();
                dialog.open();
            }

        };
        deleteButton.addListener(SWT.MouseDown, proceedListener);
        child.pack();
        child.open();
    }
}
