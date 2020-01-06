package view;

import model.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class EmployeeTableModel extends AbstractTableModel {

    private List<Employee> employees = new Vector<>();

    private static final String[] COLUMN_NAMES = {"ID", "Full Name", "Gender"};
    private static final int ID = 0;
    private static final int FULL_NAME = 1;
    private static final int GENDER = 2;

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Employee employee = employees.get(rowIndex);
        if (columnIndex == ID) {
            return employee.getM_id();
        }
        if (columnIndex == FULL_NAME) {
            return employee.getM_fullName();
        }
        if (columnIndex == GENDER) {
            return employee.isM_gender();
        }
        return employee;
    }

    public void updateEmployee(List<Employee> employees) {
        this.employees.clear();
        this.employees.addAll(employees);
        fireTableDataChanged();
    }



}
