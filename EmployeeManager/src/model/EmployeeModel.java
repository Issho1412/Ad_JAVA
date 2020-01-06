package model;

import java.util.List;

public interface EmployeeModel {
    List<Employee>  getAllEmployees();

    void addMEmployee(Employee employee);

    void updateMEmployee(Employee employee);

    void deleteMEmployee(int id);

    void registerObserver(TableObserver observer);

    void unregisterObserver(TableObserver observer);
}
