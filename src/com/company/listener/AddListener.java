package com.company.listener;

import com.company.controller.Controller;
import com.company.view.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class AddListener implements Listener {

    private Controller controller;
    private Window window;
    private Shell parent;

    public AddListener(Shell parent, Controller controller, Window window) {
        this.parent = parent;
        this.controller = controller;
        this.window = window;
    }

    @Override
    public void handleEvent(Event e) {
        Shell child = new Shell(parent);
        child.setText("Добавление");

        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 5;
        child.setLayout(rowLayout);

        Label studentNameLabel = new Label(child, SWT.NONE);
        studentNameLabel.setText("Введите имя:");

        Text studentNameText = new Text(child, SWT.NONE);
        studentNameText.setLayoutData(new RowData(200, 20));

        Label group = new Label(child, SWT.NONE);
        group.setText("Введите группу:");

        Text groupText = new Text(child, SWT.NONE);
        groupText.setLayoutData(new RowData(200, 20));

        Label first = new Label(child, SWT.NONE);
        first.setText("Введите первый семестр:");

        Text firstText = new Text(child, SWT.NONE);
        firstText.setLayoutData(new RowData(200, 20));

        Label second = new Label(child, SWT.NONE);
        second.setText("Введите второй семестр:");

        Text secondText = new Text(child, SWT.NONE);
        secondText.setLayoutData(new RowData(200, 20));

        Label third = new Label(child, SWT.NONE);
        third.setText("Введите третий семестр:");

        Text thirdText = new Text(child, SWT.NONE);
        thirdText.setLayoutData(new RowData(200, 20));

        Label fourth = new Label(child, SWT.NONE);
        fourth.setText("Введите четвертый семестр:");

        Text fourthText = new Text(child, SWT.NONE);
        fourthText.setLayoutData(new RowData(200, 20));

        Label five = new Label(child, SWT.NONE);
        five.setText("Введите пятый семестр:");

        Text fiveText = new Text(child, SWT.NONE);
        fiveText.setLayoutData(new RowData(200, 20));

        Label six = new Label(child, SWT.NONE);
        six.setText("Введите шестой семестр:");

        Text sixText = new Text(child, SWT.NONE);
        sixText.setLayoutData(new RowData(200, 20));

        Label seventh = new Label(child, SWT.NONE);
        seventh.setText("Введите седьмой семестр:");

        Text seventhText = new Text(child, SWT.NONE);
        seventhText.setLayoutData(new RowData(200, 20));

        Label eighth = new Label(child, SWT.NONE);
        eighth.setText("Введите восьмой семестр:");

        Text eighthText = new Text(child, SWT.NONE);
        eighthText.setLayoutData(new RowData(200, 20));

        Label ninth = new Label(child, SWT.NONE);
        ninth.setText("Введите девятый семестр:");

        Text ninthText = new Text(child, SWT.NONE);
        ninthText.setLayoutData(new RowData(200, 20));

        Label tenth = new Label(child, SWT.NONE);
        tenth.setText("Введите десятый семестр:");

        Text tenthText = new Text(child, SWT.NONE);
        tenthText.setLayoutData(new RowData(200, 20));

        Button proceedButton = new Button(child, SWT.PUSH);
        proceedButton.setText("добавить");
        proceedButton.setLayoutData(new RowData(100, 30));

        Listener proceedListener = new Listener() {

            @Override
            public void handleEvent(Event arg0) {

                String stName = studentNameText.getText();
                String stGroup = groupText.getText();
                int first = Integer.parseInt(firstText.getText());
                int second = Integer.parseInt(secondText.getText());
                int three = Integer.parseInt(thirdText.getText());
                int fourth = Integer.parseInt(fourthText.getText());
                int five = Integer.parseInt(fiveText.getText());
                int six = Integer.parseInt(sixText.getText());
                int seven = Integer.parseInt(seventhText.getText());
                int eight = Integer.parseInt(eighthText.getText());
                int nine = Integer.parseInt(ninthText.getText());
                int ten = Integer.parseInt(tenthText.getText());
                int result = first + second + three + fourth + five + six + seven + eight + nine + ten;

                controller.addStudent(stName,
                        stGroup,
                        first,
                        second,
                        three,
                        fourth,
                        five,
                        six,
                        seven,
                        eight,
                        nine,
                        ten,
                        result);
                window.updateTable();
                child.dispose();
            }

        };
        proceedButton.addListener(SWT.MouseDown, proceedListener);

        child.pack();
        child.open();
    }
}
