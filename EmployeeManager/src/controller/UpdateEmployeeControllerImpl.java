package controller;

import model.Employee;
import model.EmployeeModel;
import view.EmployeeView;
import view.NewEmployee;
import view.UpdateEmployee;

import javax.swing.*;
import java.awt.*;

public class UpdateEmployeeControllerImpl implements UpdateEmployeeController {
    private Component parent;

    private EmployeeModel model;

    private UpdateEmployee view;

    public UpdateEmployeeControllerImpl(Component parent, EmployeeModel model, UpdateEmployee view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void updateMEmployee() {
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "Update Employee",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            int id = view.getId();
            String fullName = view.getFullName();
            String gender = view.getGender();

            Employee employee = new Employee();
            employee.setM_id(id);
            employee.setM_fullName(fullName);
            employee.setM_gender(gender);

            model.updateMEmployee(employee);
            EmployeeView view = new EmployeeView(model);

        }
        if (option == JOptionPane.CLOSED_OPTION || option == JOptionPane.NO_OPTION){
            EmployeeView view = new EmployeeView(model);
        }

    }
}
