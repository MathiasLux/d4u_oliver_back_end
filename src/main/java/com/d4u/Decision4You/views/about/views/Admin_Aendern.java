package com.d4u.Decision4You.views.about.views;

import com.d4u.Decision4You.data.Admin;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RoutePrefix;


@PageTitle("Admin | Aendern")
@Route(value = ":id?")

public class Admin_Aendern extends VerticalLayout {
    private final ComboBox<Admin> companySelection = new ComboBox<>("Company");
    private final TextField address = new TextField("Address");
    private final TextField name = new TextField("Name");

  /*  private final Section companyFormContainer = new Section();
    private final Button save = UIFactory.btnPrimary("Save", e -> onSave());
    private final Button cancel = UIFactory.btn("Cancel", e -> onCancel());
    private final Button openEmployeeDialog = UIFactory.btnTertiary("Hire", USER_CHECK_SOLID.create(), e -> onDialogShow());
    private final Button showEmployees = UIFactory.btnTertiary("Show Employees", LIST_SOLID.create(), e -> onShowEmployees());
*/
    private final Binder<Admin> binder = new BeanValidationBinder<>(Admin.class);


    private Admin admin;

    // injected stuff
   // private final AdminService service;
   // private final EmployeeDialog employeeDialog;

}
