package controller;

import model.Employee;
import model.EmployeeModel;
import view.NewEmployee;

import javax.swing.*;
import java.awt.*;

public class NewEmployeeControllerImpl implements NewEmployeeController {
    private Component parent;

    private EmployeeModel model;

    private NewEmployee view;

    public NewEmployeeControllerImpl(Component parent, EmployeeModel model, NewEmployee view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void newEmployee() {
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "New Employee",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            String fullName = view.getFullName();
            String gender = view.getGender();

            Employee employee = new Employee();
            employee.setM_fullName(fullName);
            employee.setM_gender(gender);

            model.addMEmployee(employee);
        }
    }
}
