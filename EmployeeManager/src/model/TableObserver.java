package model;

import java.util.List;

public interface TableObserver {
    void updateTable(List<Employee> employees);
}
