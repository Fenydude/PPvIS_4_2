package com.company.view;

import com.company.controller.Controller;
import com.company.listener.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;


public class Window {
    private Controller controller;
    private StudentTable table;
    private Display display = new Display();
    private Shell shell = new Shell(display);

    public Window(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        shell.setText("LAB 2");

        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 10;
        rowLayout.marginBottom = 10;
        rowLayout.marginLeft = 5;
        rowLayout.marginRight = 5;
        rowLayout.spacing = 5;
        shell.setLayout(rowLayout);

        Menu menuBar = new Menu(shell, SWT.BAR);
        MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
        cascadeFileMenu.setText("&File");

        Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
        cascadeFileMenu.setMenu(fileMenu);

        MenuItem openItem = new MenuItem(fileMenu, SWT.PUSH);
        openItem.setText("Открыть");


        LoadListener loadListener = new LoadListener(shell, this, controller);
        openItem.addListener(SWT.Selection, loadListener);

        MenuItem saveItem = new MenuItem(fileMenu, SWT.PUSH);
        saveItem.setText("Сохранить");

        SaveListener saveListener = new SaveListener(shell, controller);
        saveItem.addListener(SWT.Selection, saveListener);


        MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
        exitItem.setText("Выход");
        shell.setMenuBar(menuBar);

        Listener exitListener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                System.exit(1);
            }
        };
        exitItem.addListener(SWT.Selection , exitListener);


        shell.setMenuBar(menuBar);
        Composite  group = new Composite (shell, SWT.HORIZONTAL);
        group.setLayout(new RowLayout(SWT.HORIZONTAL));



        Button addButton = new Button(group, SWT.PUSH);
        addButton.setText("Добавление");
        addButton.setLayoutData(new RowData(100, 30));
        AddListener addListener = new AddListener(shell, controller, this);
        addButton.addListener(SWT.MouseDown, addListener);

        Button deleteButton = new Button(group, SWT.PUSH);
        deleteButton.setText("Удаление");
        deleteButton.setLayoutData(new RowData(100, 30));
        DeleteListener deleteListener = new DeleteListener(shell, controller, this);
        deleteButton.addListener(SWT.MouseDown, deleteListener);

        Button searchButton = new Button(group, SWT.PUSH);
        searchButton.setText("Поиск");
        searchButton.setLayoutData(new RowData(60, 30));
        SearchListener searchListener = new SearchListener(shell, controller);
        searchButton.addListener(SWT.MouseDown, searchListener);








        table = new StudentTable(shell, SWT.NONE, controller);

        shell.pack();
        shell.open();
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) display.sleep();
        }
    }

    public void updateTable() {
        table.updateTable();
    }
}