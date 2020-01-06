package model;

import java.util.List;
import java.util.Vector;

public class EmployeeModelImpl implements EmployeeModel {
    private List<TableObserver> tableObservers = new Vector<>();

    @Override
    public List<Employee> getAllEmployees() {
        EmployeeDao dao = new EmployeeDaoImpl();
        return dao.getAllEmployees();
    }

    @Override
    public void addMEmployee(Employee employee) {
        EmployeeDao dao = new EmployeeDaoImpl();
        dao.insertDEmployee(employee);
        notifyObservers();
    }

    @Override
    public void updateMEmployee(Employee employee) {
        EmployeeDao dao = new EmployeeDaoImpl();
        dao.updateDEmployee(employee);
    }

    @Override
    public void deleteMEmployee(int id) {
        EmployeeDao dao = new EmployeeDaoImpl();
        dao.deleteDEmployee(id);
        notifyObservers();
    }

    @Override
    public void registerObserver(TableObserver observer) {
        if (!tableObservers.contains(observer))
            tableObservers.add(observer);
    }

    @Override
    public void unregisterObserver(TableObserver observer) {
        tableObservers.remove(observer);
    }

    private void notifyObservers() {
        List<Employee> employees = getAllEmployees();
        for (TableObserver observer: tableObservers) {
            observer.updateTable(employees);
        }
    }
}
