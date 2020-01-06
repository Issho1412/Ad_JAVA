package model;

import java.util.List;

public interface EmployeeDao {
    void insertDEmployee(Employee employee);

    // Read
    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();

    // Update
    void updateDEmployee(Employee employee);

    // Delete
    void deleteDEmployee(int id);
}
