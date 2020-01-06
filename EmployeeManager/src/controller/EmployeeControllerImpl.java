package controller;

import model.Employee;
import model.EmployeeModel;
import view.EmployeeView;

import javax.swing.*;

public class EmployeeControllerImpl  implements EmployeeController{
    private EmployeeView view;
    private EmployeeModel model;
    private JTable table;
    public EmployeeControllerImpl(EmployeeModel model) {

        this.view = new EmployeeView(model);
        this.model = model;
    }

    public EmployeeControllerImpl(EmployeeModel model, JTable table){
        this.view = new EmployeeView(model);
        this.model = model;
        this.table = table;
    }

    @Override
    public void deleteEmployee() {
        int index = view.getKey(table);
        System.out.println(index);
        model.deleteMEmployee(index);
    }

    @Override
    public void updateEmployee()
    {

    }
}
