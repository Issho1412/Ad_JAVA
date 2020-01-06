package view;

import controller.*;
import model.Employee;
import model.EmployeeModel;
import model.TableObserver;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.ArrayIndexOutOfBoundsException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;


public class EmployeeView extends JFrame implements TableObserver {
    private JPanel rootPanel;
    private JTable table1;
    private JButton btnAdd;
    private JButton btnDelete;
    private EmployeeModel model;
    private EmployeeTableModel employeeTableModel;
    int count = -1;
    public EmployeeView(EmployeeModel model) {

        this.model = model;
        this.model.registerObserver(this);

        setTitle("Employee Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
        employeeTableModel = new EmployeeTableModel();
        table1.setModel(employeeTableModel);

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2){
                    onUpdateEmployee();
                }
            }
        });
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                btnDelete.setEnabled(true);
            }
        });


        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddEmployee(e);
            }
        });


        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRemoveEmployee();
                dispose();
            }
        });
        List<Employee> employees = this.model.getAllEmployees();
        employeeTableModel.updateEmployee(employees);
    }



    private void onRemoveEmployee(){
        EmployeeController employeeController = new EmployeeControllerImpl(model, table1);
        employeeController.deleteEmployee();
    }

    public int getKey(JTable table){
        int row = table.getSelectedRow();
        String value = table.getModel().getValueAt(row, 0).toString();
        return Integer.parseInt(value);
    }
    private void onAddEmployee(ActionEvent e) {
        NewEmployeeController controller = new NewEmployeeControllerImpl(this, model, new NewEmployee());
        controller.newEmployee();
    }
    private void onUpdateEmployee() {
        int row = table1.getSelectedRow();
        int id = Integer.parseInt(table1.getModel().getValueAt(row, 0).toString());
        String fullName = table1.getModel().getValueAt(row, 1).toString();
        String gender = table1.getModel().getValueAt(row, 2).toString();
        UpdateEmployeeController controller = new UpdateEmployeeControllerImpl(this, model, new UpdateEmployee(this ,id, fullName, gender));
        controller.updateMEmployee();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void updateTable(List<Employee> employees) {
        employeeTableModel.updateEmployee(employees);
    }

    public void mouseClicked(MouseEvent event)
    {
        if (event.getClickCount() == 2) {
            onUpdateEmployee();
        }
    }
}
